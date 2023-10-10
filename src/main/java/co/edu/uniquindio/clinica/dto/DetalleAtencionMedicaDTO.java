package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.TipoSangre;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(
        int codigoCita,
        String nombrePaciente,
        String especialidad,
        LocalDateTime fechaAtencion,
        String tratamiento,
        String notasMedicas,
        String diagnostico,
        TipoSangre tipoSangre,
        EPS eps
) {
}
