package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PQRSRepo  extends JpaRepository<Pqrs, Integer> {

    List<Pqrs> findAllByCita_PacienteCodigo(int codigoPaciente);



    long countByPacienteCodigoAndEstado(int codigoPaciente, String estado);

}
