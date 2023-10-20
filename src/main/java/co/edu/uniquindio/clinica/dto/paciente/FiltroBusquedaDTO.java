package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.enums.TipoSangre;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FiltroBusquedaDTO(

        @NotNull int codigoCita,
        @NotNull int codigoPaciente,
        @NotNull int codigoMedico,
        @NotNull @Length(max = 200) String nombreMedico,
        @NotNull Especialidad especialidad,
        @NotNull @Length(max = 200) String nombrePaciente,
        @NotNull LocalDate fechaNacimiento,
        @NotNull LocalDateTime fechaAtencion,
        @NotNull Ciudad ciudad,
        @NotNull EPS eps,
        @NotNull TipoSangre tipoSangre,
        @NotNull @Lob String alergias,
        @Lob @NotNull String motivo,
        @NotNull String notasMedicas
) {





}
