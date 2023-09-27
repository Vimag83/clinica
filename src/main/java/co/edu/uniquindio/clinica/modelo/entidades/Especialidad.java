package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

public enum Especialidad {
    MEDICINA_INTERNA("Medicina Interna"),
    CIRUGIA("Cirugía"),
    PEDIATRIA("Pediatría"),
    GINECOLOGIA_OBSTETRICIA("Ginecología y Obstetricia"),
    MEDICINA_FAMILIAR("Medicina Familiar"),
    CARDIOLOGIA("Cardiología"),
    DERMATOLOGIA("Dermatología"),
    PSIQUIATRIA("Psiquiatría"),
    NEUMOLOGIA("Neumología"),
    OFTALMOLOGIA("Oftalmología"),
    MEDICINA_EMERGENCIA("Medicina de Emergencia"),
    RADIOLOGIA("Radiología"),
    MEDICINA_DEPORTIVA("Medicina Deportiva"),
    ENDOCRINOLOGIA("Endocrinología"),
    GASTROENTEROLOGIA("Gastroenterología");

    private String nombre;

    Especialidad(String nombre) {
        this.nombre = nombre;
    }

}
