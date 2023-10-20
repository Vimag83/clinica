package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.dto.medico.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HorarioRepo extends JpaRepository <Horario, Integer>{
    //List<HorarioDTO> findByDiaAndHoraInicialAndHoraFinal(LocalDateTime dia, LocalDateTime horainicio, LocalDateTime horaSalida);

    List <Horario> findByDiaAndHoraInicialAndHoraFinal(LocalDateTime dia, LocalDateTime horainicio, LocalDateTime horaSalida);
}