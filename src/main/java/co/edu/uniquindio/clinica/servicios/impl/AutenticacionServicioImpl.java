package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.clinica.repositorios.CuentaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.AutenticacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final CuentaRepo cuentaRepo;


    @Override
    public Cuenta login(LoginDTO loginDTO) throws Exception {
        String usuario = loginDTO.usuario();
        String password = loginDTO.password();

        Cuenta cuenta = cuentaRepo.findByCorreoAndPassword(usuario, password);

        if (cuenta == null) {
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return cuenta;
    }
}