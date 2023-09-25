package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(

        int codigoCita,
        String nombrePaciente,
        String cedulaPaciente,
        String nombreMedico,
        String especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha,
        String motivo
) {
}
