package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.modelo.entidades.FormulaMedica;
import co.edu.uniquindio.clinica.modelo.entidades.OrdenMedica;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

public record RegistroAtencionDTO(
        @NotNull int codigoCita,
        @NotNull int codigoMedico,
        @NotNull @Lob String notasMedicas,
        @NotNull @Lob String tratamiento,
        @NotNull @Lob String diagnostico,

        @NotNull
        OrdenMedica ordenMedica,

        @NotNull
        FormulaMedica formulaMedica
) {
}
