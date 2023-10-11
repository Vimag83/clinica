package co.edu.uniquindio.clinica.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RespuestaDTO(

        @NotNull int codigoMensaje,
        @NotNull @Lob String mensaje,
        @NotNull @Length(max = 200) String nombreUsuario,
        @NotNull LocalDateTime fecha
) {
}
