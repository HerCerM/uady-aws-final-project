package hercerm.college.uadyawsfinalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Student {
    @Id
    @NotNull
    Long id;

    @NotBlank
    String nombres;

    @NotBlank
    String apellidos;

    @NotBlank
    String matricula;

    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    Double promedio;
}