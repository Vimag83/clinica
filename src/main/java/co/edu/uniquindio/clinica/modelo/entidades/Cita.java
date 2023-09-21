package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter@Getter
public class Cita extends Paciente implements Serializable {
    private String codigocita;
    private LocalDate fechaCreacion;
    private LocalDate fechaCita;

    @ManyToOne
    private Paciente paciente;

    @OneToMany(mappedBy = "cita")
    private List<Pqrs> pqrs;
}
