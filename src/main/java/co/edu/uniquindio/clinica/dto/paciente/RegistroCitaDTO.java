package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        int codigoPaciente,
        LocalDateTime fecha,
        int codigoMedico,
        String motivo
) {

}
