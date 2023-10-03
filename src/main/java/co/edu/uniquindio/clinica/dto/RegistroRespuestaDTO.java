package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EstadoPQRS;

import java.time.LocalDateTime;
public record RegistroRespuestaDTO(
        int codigoCuenta,
        int codigoPQRS,
        int codigoMensaje,
        String mensaje
) {
}
