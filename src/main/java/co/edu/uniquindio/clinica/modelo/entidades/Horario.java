package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Horario implements Serializable {

    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "Dia")
    private LocalDate dia;

    @Column(name = "Inicio")
    private LocalDateTime horaInicial;

    @Column(name = "Fin")
    private LocalDateTime horaFinal;

    @ManyToOne
    private Medico medico;


}
