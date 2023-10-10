package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.dto.admin.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.enums.DiaLibre;
import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;

import java.util.List;

public record DetalleMedicoDTO(

        int codigo,
        String nombre,
        String cedula,
        String telefono,
        String correo,
        List<HorarioDTO> horarios,
        Especialidad especialidad,
        Horario horario,
        DiaLibre diaLibre,
        Ciudad ciudad,
        String urlFoto
) {
}
