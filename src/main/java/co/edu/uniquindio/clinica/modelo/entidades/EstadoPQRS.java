package co.edu.uniquindio.clinica.modelo.entidades;

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
