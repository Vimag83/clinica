package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

public enum EstadoPQRS {

        ABIERTA("Abierta"),
        EN_PROCESO("En proceso"),
        RESUELTA("Resuelta"),
        CERRADA("Cerrada");

        private String nombre;

        EstadoPQRS(String nombre) {
            this.nombre = nombre;
        }


}
