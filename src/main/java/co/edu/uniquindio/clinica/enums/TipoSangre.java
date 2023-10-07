package co.edu.uniquindio.clinica.enums;

public enum TipoSangre {

    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-");

    private String nombre;

    TipoSangre(String nombre){
        this.nombre = nombre;
    }

}
