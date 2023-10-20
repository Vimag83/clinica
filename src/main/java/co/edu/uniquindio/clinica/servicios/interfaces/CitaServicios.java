package co.edu.uniquindio.clinica.servicios.interfaces;

public interface CitaServicios {

    void agendarCita();
    void cancelarCita();
    void listarCitasPaciente();//codigo paciente y codigo medico
    void verDetalleCita();
    void filtrarCitasPorMedicoFecha();
    void listarCitasPendientesMedico();
    void atenderCita();
    void listarTodasCitasMedico();//parametro codigo medico
}
