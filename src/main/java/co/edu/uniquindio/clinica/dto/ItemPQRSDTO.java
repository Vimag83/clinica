package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(int codigo,
                          Estado_PQRS estado,
                          String motivo,
                          LocalDateTime fecha,
                          String nombrePaciente
) {
}
