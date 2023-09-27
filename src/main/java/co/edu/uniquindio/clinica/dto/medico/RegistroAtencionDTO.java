package co.edu.uniquindio.clinica.dto.medico;

public record RegistroAtencionDTO(
        String codigoCita,
        int codigoMedico,
        String notasMedicas,
        String tratamiento,
        String diagnostico
) {
}
