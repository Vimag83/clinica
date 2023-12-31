package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO(
        @NotNull int codigo,
        @NotNull String estado,
        @NotNull int codigoCita,
        @NotNull String motivo,
        @NotNull @Length(max = 200) String nombrePaciente,
        @NotNull
        LocalDateTime fechaCreacion,
        List<String> mensajes
) {
}
