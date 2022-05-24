package hercerm.college.uadyawsfinalproject.service.impl;

import hercerm.college.uadyawsfinalproject.model.Student;
import hercerm.college.uadyawsfinalproject.repository.StudentRepository;
import hercerm.college.uadyawsfinalproject.service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}
