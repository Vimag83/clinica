package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.enums.EstadoCita;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(

        @NotNull int codigoCita,
        @Column(length = 200, nullable = false) String nombrePaciente,
        @Column(length = 10, nullable = false, unique = true) String cedulaPaciente,
        @Column(length = 200, nullable = false) String nombreMedico,
        @NotNull Especialidad especialidad,
        @NotNull EstadoCita estadoCita,
        @NotNull LocalDateTime fechaCita

) {
}
