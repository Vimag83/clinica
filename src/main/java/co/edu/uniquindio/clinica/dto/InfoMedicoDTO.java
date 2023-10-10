package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.dto.admin.HorarioDTO;

import java.util.List;

public record InfoMedicoDTO(

        int codigo,
        String nombre,
        String cedula,
        int codigoCiudad,
        int codigoEspecialidad,
        String telefono,
        String correo,
        List<HorarioDTO> horarios
) {
}
