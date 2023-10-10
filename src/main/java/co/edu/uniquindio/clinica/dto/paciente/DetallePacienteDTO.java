package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.TipoSangre;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetallePacienteDTO(
        int codigo,
        String nombre,
        String cedula,
        String telefono,
        String urlFoto,
        LocalDate fechaNacimiento,
        String alergias,
        String correo,
        Ciudad ciudad,
        EPS eps,
        TipoSangre tipoSangre
) {
}
