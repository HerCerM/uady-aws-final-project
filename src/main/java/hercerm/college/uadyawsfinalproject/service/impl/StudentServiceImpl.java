package hercerm.college.uadyawsfinalproject.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import hercerm.college.uadyawsfinalproject.config.AwsConfig;
import hercerm.college.uadyawsfinalproject.model.Student;
import hercerm.college.uadyawsfinalproject.repository.StudentRepository;
import hercerm.college.uadyawsfinalproject.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final AwsConfig awsConfig;

    public StudentServiceImpl(StudentRepository studentRepository, AwsConfig awsConfig) {
        this.studentRepository = studentRepository;
        this.awsConfig = awsConfig;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id)
            .map(Optional::of)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        Student storedStudent = getById(id).orElseThrow(EntityNotFoundException::new);
        student.setId(storedStudent.getId());
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        studentRepository.deleteById(id);
    }

    @Override
    public Student uploadProfilePicture(MultipartFile file, Long id) throws IOException {
        Student storedStudent = getById(id).orElseThrow(EntityNotFoundException::new);

        BasicSessionCredentials awsCredentials = new BasicSessionCredentials(
            awsConfig.getAccessKeyId(), awsConfig.getAwsSecretAccessKey(), awsConfig.getAwsSessionToken());

        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
            .withRegion(Regions.US_WEST_2)
            .build();

        String s3ObjectKey = String.format("fotos/%s_%s_fotoPerfil_%s",
            storedStudent.getMatricula(), storedStudent.getNombres(), file.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        PutObjectRequest putObjectRequest = new PutObjectRequest(
            awsConfig.getStudentBucketName(), s3ObjectKey, file.getInputStream(), objectMetadata)
            .withCannedAcl(CannedAccessControlList.PublicRead);

        s3.putObject(putObjectRequest);

        storedStudent.setFotoPerfilUrl(String.format("https://%s.s3.amazonaws.com/%s",
            awsConfig.getStudentBucketName(), s3ObjectKey).replaceAll("\\s", "+"));
        studentRepository.save(storedStudent);

        return storedStudent;
    }
}
