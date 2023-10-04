package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.DiaLibre;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;

import java.util.List;

public record DetalleMedicoDTO(

        int codigo,
        String nombre,
        String cedula,

        String telefono,
        String correo,
        List<HorarioDTO> horarios,
        Especialidad  especialidad,
        DiaLibre diaLibre,
        Ciudad ciudad,
        String urlFoto



) {

}
