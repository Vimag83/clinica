package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;

public interface AutenticacionServicio {

    Cuenta login(LoginDTO loginDTO) throws Exception;
}