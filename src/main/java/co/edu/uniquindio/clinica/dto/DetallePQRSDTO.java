package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        Estado_PQRS estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes
) {
}
