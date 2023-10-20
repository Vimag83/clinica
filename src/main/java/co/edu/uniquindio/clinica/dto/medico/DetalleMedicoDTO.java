package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.dto.admin.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.enums.DiaLibre;
import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record DetalleMedicoDTO(

        @NotNull int codigo,
        @Column(length = 200, nullable = false) String nombre,
        @Column(length = 10, nullable = false, unique = true) String cedula,
        @Column(length = 20, nullable = false) String telefono,
        @Email @Length(max = 80) @NotNull String correo,
        List<HorarioDTO> horarios,
        @NotNull Especialidad especialidad,
        Horario horario,
        DiaLibre diaLibre,
        @NotNull Ciudad ciudad,
        @NotNull String urlFoto
) {
}
