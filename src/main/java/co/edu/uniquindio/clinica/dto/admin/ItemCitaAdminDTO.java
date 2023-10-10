package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(

        int codigoCita,
        String nombrePaciente,
        String cedulaPaciente,
        String nombreMedico,
        Especialidad especialidad,
        EstadoCita estadoCita,
        LocalDateTime fechaCita

) {
}
