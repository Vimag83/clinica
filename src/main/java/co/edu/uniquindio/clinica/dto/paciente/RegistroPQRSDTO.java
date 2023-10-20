package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

public record RegistroPQRSDTO(
        @NotNull int codigoCita,
        @NotNull int codigoPaciente,
        @NotNull String tipoPQRS,
        @NotNull @Lob String motivo,
        @NotNull Mensaje mensaje
) {
}
