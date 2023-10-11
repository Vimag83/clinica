package co.edu.uniquindio.clinica.dto.medico;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

public record RegistroAtencionDTO(
        @NotNull String codigoCita,
        @NotNull int codigoMedico,
        @NotNull @Lob String notasMedicas,
        @NotNull @Lob String tratamiento,
        @NotNull @Lob String diagnostico
) {
}
