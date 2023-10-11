package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.enums.Especialidad;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record ItemMedicoDTO(

        @NotNull Integer codigo,
        @Column(length = 200, nullable = false) String nombre,
        @Column(length = 10, nullable = false, unique = true) String cedula,
        String urlFoto,
        @NotNull Especialidad especialidad) {
}
