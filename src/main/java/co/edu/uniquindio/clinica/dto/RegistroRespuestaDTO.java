package co.edu.uniquindio.clinica.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuestaDTO(
        @NotNull int codigoCuenta,
        @NotNull int codigoPQRS,
        @NotNull int codigoMensaje,
        @NotNull @Lob String mensaje
) {
}
