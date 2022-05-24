package hercerm.college.uadyawsfinalproject.controller;

import hercerm.college.uadyawsfinalproject.model.Professor;
import hercerm.college.uadyawsfinalproject.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProfessorController.BASE_URL)
public class ProfessorController {

    public static final String BASE_URL = "/profesores";

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getOneProfessor(@PathVariable Long id) {
        return professorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor createProfessor(@RequestBody @Valid Professor professor) {
        return professorService.create(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@RequestBody @Valid Professor professor, @PathVariable Long id) {
        return professorService.update(professor, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
    }
}
