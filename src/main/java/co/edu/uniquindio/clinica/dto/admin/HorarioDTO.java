package co.edu.uniquindio.clinica.dto.admin;

import jakarta.validation.constraints.NotNull;

public record HorarioDTO(
        @NotNull int codigo,
        String dia,
        String horaInicio,
        String horaSalida
) {
}
