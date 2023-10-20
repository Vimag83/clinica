package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer> {

    Cuenta findByCodigo(int codigo);
    Cuenta findByCorreo(String correo);

    Cuenta findByCorreoAndPassword(String usuario, String password);
}
