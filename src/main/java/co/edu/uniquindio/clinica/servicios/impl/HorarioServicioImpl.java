package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.medico.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import co.edu.uniquindio.clinica.repositorios.HorarioRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.HorarioServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class HorarioServicioImpl implements HorarioServicio {

    private final HorarioRepo horarioRepo;
    @Override
    public void asignarDia(HorarioDTO horarioDTO) throws Exception {
        Horario horario = new Horario();

        horario.setDia(horarioDTO.dia());
        horario.setHoraInicial(horarioDTO.horaInicio());
        horario.setHoraFinal(horarioDTO.horaSalida());
    }

    @Override
    public void cancelarDia(HorarioDTO horarioDTO) throws Exception {


    }



    @Override
    public List<HorarioDTO> listarDiasLaborales() throws Exception {

        List<Horario> horarios = horarioRepo.findAll();

        if (horarios.isEmpty()){
            throw new Exception("No hay citas asignadas");
        }
        List<HorarioDTO>respuesta = new ArrayList<>();
        for (Horario h: horarios){
            respuesta.add(new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicial(),
                    h.getHoraFinal()
            ));
        }

        return respuesta;
    }
}
