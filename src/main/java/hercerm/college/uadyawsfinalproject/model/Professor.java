package hercerm.college.uadyawsfinalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue
    Long id;
    Long employeeNumber;
    String names;
    String surnames;
    Integer classHours;
}
