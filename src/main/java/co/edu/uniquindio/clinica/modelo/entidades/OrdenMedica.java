package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter@Getter
public class OrdenMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoOrden;


    @Lob()
    @Column(name = "descripción")
    private String descripcion;

    @ManyToOne
    private Atencion atencion;

    @OneToMany(mappedBy = "ordenMedica")
    private List<FormulaMedica> formulasMedicas;
}
