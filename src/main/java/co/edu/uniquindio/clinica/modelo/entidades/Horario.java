package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Horario extends  Medico implements Serializable {

   // @Id
    //private Integer codigo;
    private LocalDate dia;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;

    @ManyToOne
    private Medico medico;


}
