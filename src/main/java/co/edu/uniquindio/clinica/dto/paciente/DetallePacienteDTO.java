package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.TipoSangre;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

public record DetallePacienteDTO(
        @NotNull int codigo,
        @NotNull @Length(max = 200) String nombre,
        @NotNull @Length(max = 10) @UniqueElements String cedula,
        @NotNull @Length(max = 20) String telefono,
        @NotNull String urlFoto,
        @NotNull LocalDate fechaNacimiento,
        @NotNull @Lob String alergias,
        @Email @NotNull @Length(max = 80) String correo,
        @NotNull Ciudad ciudad,
        @NotNull EPS eps,
        @NotNull TipoSangre tipoSangre
) {
}
