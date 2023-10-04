package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs extends Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDate fechaCreacion;


    private String tipo;

    @Column(nullable = false)
    private  EstadoPQRS estado;

    @Lob
    @Column(nullable = false)
    private String motivo;


    @ManyToOne
    @Column(nullable = false)
    private Cita cita;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

}
