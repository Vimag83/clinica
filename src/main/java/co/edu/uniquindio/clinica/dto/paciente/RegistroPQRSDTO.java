package co.edu.uniquindio.clinica.dto.paciente;

public record RegistroPQRSDTO(
        int codigoCita,
        int codigoPaciente,
        String motivo,
        String tipoPQRS
) {
}
