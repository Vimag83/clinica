package co.edu.uniquindio.clinica.dto.admin;


import co.edu.uniquindio.clinica.dto.HorarioDTO;

import java.util.List;

public record RegistroMedicoDTO(
        String nombre,
        String cedula,
        int codigoCiudad,
        int codigoEspecialidad,
        String telefono,
        String correo,
        String password,
        List<HorarioDTO> horarios
) {
}
