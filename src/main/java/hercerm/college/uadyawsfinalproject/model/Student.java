package hercerm.college.uadyawsfinalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    String nombres;

    @NotBlank
    String apellidos;

    @NotBlank
    String matricula;

    @DecimalMax("100")
    @DecimalMin("0")
    Double promedio;

    String fotoPerfilUrl;
}
