package hercerm.college.uadyawsfinalproject.service.impl;

import hercerm.college.uadyawsfinalproject.model.Professor;
import hercerm.college.uadyawsfinalproject.repository.ProfessorRepository;
import hercerm.college.uadyawsfinalproject.service.ProfessorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> getById(Long id) {
        return professorRepository.findById(id)
            .map(Optional::of)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(Long id) {
        professorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        professorRepository.deleteById(id);
    }
}
