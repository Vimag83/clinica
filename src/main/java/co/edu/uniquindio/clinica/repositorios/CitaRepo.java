package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.enums.EstadoCita;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    //Buscar por codigo del paciente
    public List<Cita> findAllByPacienteCodigo(int codigoPaciente);

    @Query("select c from Cita c where c.paciente.codigo=:codigoUsuario")
    public List<Cita> listarCitaUsuario(String codigoUsuario);

    public List<Cita> findAllByFechadeAtencion(LocalDateTime fechaAtencion);

    public List<Cita> findAllByMedicoCodigoAndEstadoCita(int codigoMedico, EstadoCita estadoCita);

    public Cita findAllByCodigoCita(int codigoCita);
}
