package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class Horario extends Medico implements Serializable {

    private LocalDate dia;
    private LocalTime horaInicial, horaFinal;

   // @OneToMany
   // private Medico medico;
}
