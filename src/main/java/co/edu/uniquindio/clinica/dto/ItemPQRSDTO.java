package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.EstadoPQRS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ItemPQRSDTO(int codigo,
                          EstadoPQRS estado,
                          String motivo,
                          LocalDate fechaCreacion,
                          String nombrePaciente
) {
}
