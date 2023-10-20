package co.edu.uniquindio.clinica.dto.admin;


import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

public record RegistroMedicoDTO(
        @NotNull int codigo,
        @NotNull @Length(max = 200) String nombre,
        @NotNull @UniqueElements @Length(max = 10) String cedula,
        @NotNull Ciudad ciudad,
        @NotNull Especialidad especialidad,
        @NotNull @Length(max = 20) String telefono,
        @NotNull @Email @Length(max = 80) String correo,
        @NotNull String password,
        @NotNull String urlFoto,
        List<HorarioDTO> horarios
) {
}
