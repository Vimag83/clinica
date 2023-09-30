package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.LoginDTO;

public interface AutenticacionServicio {

    void login(LoginDTO loginDTO) throws Exception;
}
