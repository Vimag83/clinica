package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LoginDTO(
        @NotNull @Email @Length(max = 80) String correo,
        @NotNull String password
) {
}
