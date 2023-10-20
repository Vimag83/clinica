package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.enums.DiaLibre;
import co.edu.uniquindio.clinica.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.servicios.impl.AdministradorServicioImpl;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministradorServicioImplTest {

    @Autowired
    AdministradorServicioImpl administradorServicio;

    Ciudad ciudad ;
    Medico medico;
    Horario horario;
    Cita cita;



    @Test
    void crearMedico() {
    }

    @Test
    void actualizarMedico() {
    }

    @Test
    void eliminarMedico() {
    }

    @Test
    @Sql("classpath:dataset.sql" )
    void listarMedicos() {
        try {
            administradorServicio.listarMedicos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void obtenerMedico() {
    }

    @Test
    void listarPQRS() {
    }

    @Test
    void responderPQRS() {
    }

    @Test
    void verDetallePQRS() {
    }

    @Test
    void cambiarEstadoPQRS() {
    }

    @Test
    void listarCitas() {
    }
}