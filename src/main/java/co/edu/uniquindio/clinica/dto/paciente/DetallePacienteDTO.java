package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.EPS;
import co.edu.uniquindio.clinica.modelo.entidades.TipoSangre;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
