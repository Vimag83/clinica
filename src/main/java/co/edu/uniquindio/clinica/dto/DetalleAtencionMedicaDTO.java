package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EPS;
import co.edu.uniquindio.clinica.modelo.entidades.Tipo_sangre;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(
        int codigoCita,
        String nombrePaciente,
        String especialidad,
        LocalDateTime fechaAtencion,
        String tratamiento,
        String notasMedicas,
        String diagnostico,
        Tipo_sangre tipoSangre,
        EPS eps
) {
}
