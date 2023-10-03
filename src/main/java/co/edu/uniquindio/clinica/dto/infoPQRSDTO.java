package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;
import java.util.List;

public record infoPQRSDTO(
        int codigo,
        String estado,
        int codigoCita,
        String motivo,
        String nombrePaciente,
        LocalDateTime fecha,
        List<String> mensajes

) {
}