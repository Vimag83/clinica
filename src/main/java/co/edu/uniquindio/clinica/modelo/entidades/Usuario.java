package co.edu.uniquindio.clinica.modelo.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Cuenta implements Serializable{
    @ManyToOne
    private Ciudad ciudad;

    private String cedula;
    private String nombre;
    private String urlFoto;
    private String telefono;

}
