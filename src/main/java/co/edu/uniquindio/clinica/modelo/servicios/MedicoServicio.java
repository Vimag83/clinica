package co.edu.uniquindio.clinica.modelo.servicios;

public interface MedicoServicio {
    void listarCitasPendientes();

    void atenderCita();

    void listarCitasPaciente(); //historial médico

    void agendarDiaLibre();

    void listarCitasRealizadasMedico();
}
