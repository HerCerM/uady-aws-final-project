package hercerm.college.uadyawsfinalproject.service;

import hercerm.college.uadyawsfinalproject.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService extends GenericCrudService<Student, Long> {
    Student uploadProfilePicture(MultipartFile file, Long id) throws IOException;
}
