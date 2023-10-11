package co.edu.uniquindio.clinica.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

public record EmailDTO(
        @NotNull @Lob
        String para, String asunto, String mensaje
) {
}
