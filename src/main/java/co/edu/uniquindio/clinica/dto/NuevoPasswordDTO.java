package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

public record NuevoPasswordDTO(
        @NotNull int codigoCuenta,
        @NotNull String nuevoPassword ) {
}
