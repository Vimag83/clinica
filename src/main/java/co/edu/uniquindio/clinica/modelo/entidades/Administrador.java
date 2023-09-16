package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@NoArgsConstructor
public class Administrador extends Cuenta implements Serializable{


}
