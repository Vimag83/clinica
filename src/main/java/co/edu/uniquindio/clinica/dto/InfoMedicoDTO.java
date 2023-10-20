package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.dto.admin.HorarioDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record InfoMedicoDTO(

        @NotNull int codigo,
        @Column(length = 200, nullable = false) String nombre,
        @Column(length = 10, nullable = false, unique = true) String cedula,
        @NotNull int codigoCiudad,
        @NotNull int codigoEspecialidad,
        @NotNull @Length(max = 20) String telefono,
        @Email @NotNull @Length(max = 80) String correo,
        List<HorarioDTO> horarios
) {
}
