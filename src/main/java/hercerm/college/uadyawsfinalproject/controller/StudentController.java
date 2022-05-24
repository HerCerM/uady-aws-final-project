package hercerm.college.uadyawsfinalproject.controller;

import hercerm.college.uadyawsfinalproject.model.Student;
import hercerm.college.uadyawsfinalproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(StudentController.BASE_URL)
public class StudentController {

    public static final String BASE_URL = "/alumnos";

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getOneStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody @Valid Student student) {
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody @Valid Student student, @PathVariable Long id) {
        return studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}

