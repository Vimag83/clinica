package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes
) {
}
