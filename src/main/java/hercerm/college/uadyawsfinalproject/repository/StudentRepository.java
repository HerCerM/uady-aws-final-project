package hercerm.college.uadyawsfinalproject.repository;

import hercerm.college.uadyawsfinalproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
