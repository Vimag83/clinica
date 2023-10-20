package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.medico.HorarioDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface HorarioServicio {
    void asignarDia(HorarioDTO horarioDTO)throws Exception;
    void cancelarDia(HorarioDTO horarioDTO) throws Exception;

    List<HorarioDTO> listarDiasLaborales() throws Exception;
}
