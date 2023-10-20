package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DiaLibreDTO(
        @NotNull int codigoMedico,
        @NotNull LocalDate fecha
) {
}
