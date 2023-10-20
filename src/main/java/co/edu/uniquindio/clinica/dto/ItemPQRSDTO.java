package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
          @NotNull EstadoPQRS estado,
          @NotNull String motivo,
          @NotNull LocalDateTime fechaCreacion,
          @NotNull @Length(max = 200) String nombrePaciente
) {
}
