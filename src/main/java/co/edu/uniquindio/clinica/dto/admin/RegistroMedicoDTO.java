package co.edu.uniquindio.clinica.dto.admin;


import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;

import java.util.List;

public record RegistroMedicoDTO(
        String nombre,
        String cedula,
        Ciudad ciudad,
        //int codigoEspecialidad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        List<HorarioDTO> horarios,
        String urlFoto
) {
}
