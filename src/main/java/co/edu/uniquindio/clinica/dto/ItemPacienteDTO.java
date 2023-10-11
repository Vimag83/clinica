package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ItemPacienteDTO(

        @NotNull int codigo,
        @NotNull @Length(max = 10) String cedula,
        @NotNull @Length(max = 200) String nombre,
        @NotNull Ciudad ciudad
) {
}
