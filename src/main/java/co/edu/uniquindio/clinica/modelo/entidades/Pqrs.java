package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoPqrs;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private EstadoPQRS estado;

    @Lob
    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cita cita;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

}
