package hercerm.college.uadyawsfinalproject.repository;

import hercerm.college.uadyawsfinalproject.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
