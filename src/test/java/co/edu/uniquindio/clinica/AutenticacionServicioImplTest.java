package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.servicios.impl.AutenticacionServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AutenticacionServicioImplTest {

    @Autowired
    AutenticacionServicioImpl autenticacionServicioImpl;

    @BeforeEach
    void setUp() {

    }

    @Test
    void login() {
        LoginDTO loginDTO = new LoginDTO("Edisson", "xxxx");

        try {
            autenticacionServicioImpl.login(loginDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}