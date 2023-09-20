package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter@Getter
public class OrdenMedica extends Atencion implements Serializable {
    private String descripcion;

    @ManyToOne
    private Atencion atencion;
}
