package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(

        int codigoCita,
        String nombrePaciente,
        String cedulaPaciente,
        String nombreMedico,
        Especialidad especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha

) {
}
