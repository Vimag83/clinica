package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter@Getter
public class FormulaMedica extends OrdenMedica implements Serializable {
    private String descripcion;

    //creo que tambien es de uno a uno con la orden medica
}
