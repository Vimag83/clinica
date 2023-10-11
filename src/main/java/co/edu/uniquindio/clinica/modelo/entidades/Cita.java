package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.enums.EstadoCita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter@Getter
public class Cita implements Serializable {

    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigocita;

    @Column(name = "motivoConsula", nullable = false)
    private String motivo;

    @Column(nullable = false)
    private EstadoCita estadoCita;

    @Column(name = "fechaCita", nullable = false)
    private LocalDateTime fechadeAtencion;

    @Column(name = "Fecha de Creación", nullable = false)
    private LocalDateTime fechadeCreacion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "cita")
    private List<Pqrs> pqrs;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;
}
