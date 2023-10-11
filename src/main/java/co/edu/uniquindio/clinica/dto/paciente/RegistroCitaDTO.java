package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        @NotNull int codigoCita,
        @NotNull int codigoPaciente,
        @NotNull LocalDateTime fecha,
        @NotNull int codigoMedico,
        @Lob @NotNull String motivo
) {

}
