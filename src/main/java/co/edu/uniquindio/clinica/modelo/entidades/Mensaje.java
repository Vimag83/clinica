package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje implements Serializable{
    @ManyToOne
    private Cuenta cuenta;

    @ManyToOne
    private Pqrs pqrs;

    @Id
    private Integer codigo;

    private LocalDateTime fechaCreacion;
    private String mensaje;
    private String contenido;


}
