package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
@Setter@Getter
public class Pqrs extends Cita implements Serializable {
    private LocalDate fechaCreacion;
    private String tipo;
    private String motivo;

    @ManyToOne
    private Cita cita;
}
