package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter@Getter
public class Atencion implements Serializable {

    @Id
    private Integer codigo;
    @Lob()
    private String diagnostico;
    @Lob()
    private String tratamiento;
    @Column(name="notas médicas", length = 100)
    private String notasMedicas;
    //Este creo que debe ser de uno a uno con la cita, preguntar al profe

    @OneToOne
    private Cita cita;

    @OneToMany(mappedBy = "atencion")
    private List<OrdenMedica> ordenesMedicas;
}
