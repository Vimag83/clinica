package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter@Getter
public class FormulaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoFormula;

    @Column(name = "formula")
    private String descripcion;

    @ManyToOne
    private OrdenMedica ordenMedica;
}
