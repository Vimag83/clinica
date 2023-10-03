package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Horario extends  Medico implements Serializable {

    private LocalDate dia;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;

    @OneToMany
    private  Medico medico;

}
