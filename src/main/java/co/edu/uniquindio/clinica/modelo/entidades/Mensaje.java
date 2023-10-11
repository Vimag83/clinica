package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column (name = "Fecha", nullable = false)
    private LocalDateTime fechaCreacion;

    @Lob @NotNull
    private String mensaje;

    @Lob private String contenido;

    @ManyToOne
    private Cuenta cuenta;

    @ManyToOne
    private Pqrs pqrs;



}
