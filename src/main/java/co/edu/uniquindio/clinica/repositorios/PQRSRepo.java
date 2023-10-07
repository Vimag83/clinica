package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PQRSRepo  extends JpaRepository<Pqrs, Integer> {

    List<Pqrs> findAllByCita_PacienteCodigo(int codigoPaciente);

}
