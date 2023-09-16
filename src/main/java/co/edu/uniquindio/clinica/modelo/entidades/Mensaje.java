package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje implements Serializable{
    @ManyToOne
    private Cuenta cuenta;

    @Id
    private Integer codigo;
    private Date fechaCreacion;
    private String mensaje;


}
