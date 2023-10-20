package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        @NotNull int codigo,
        @NotNull EstadoPQRS estado,
        @NotNull @Lob String motivoPQRS,
        @NotNull @Length(max = 200) String nombrePaciente,
        @NotNull @Length(max = 200) String nombreMedico,
        @NotNull Especialidad especialidad,
        @NotNull LocalDateTime fecha,
        List<RespuestaDTO> mensajes
) {
}
