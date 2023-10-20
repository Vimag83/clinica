package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.enums.TipoSangre;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(
        @NotNull int codigoCita,
        @NotNull @Length(max = 200) String nombrePaciente,
        @NotNull @Length(max = 200) String nombreMedico,
        @NotNull Especialidad especialidad,
        @NotNull LocalDateTime fechaAtencion,
        @NotNull @Lob String tratamiento,
        @NotNull @Length(max = 100) String notasMedicas,
        @NotNull @Lob String diagnostico,
        @NotNull TipoSangre tipoSangre,
        @NotNull EPS eps
) {
}
