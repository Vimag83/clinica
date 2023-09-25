package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EPS;
import co.edu.uniquindio.clinica.modelo.entidades.TipoSangre;

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
