package hercerm.college.uadyawsfinalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    String nombres;

    @NotBlank
    String apellidos;

    @Positive
    Integer numeroEmpleado;

    @Positive
    Integer horasClase;
}
