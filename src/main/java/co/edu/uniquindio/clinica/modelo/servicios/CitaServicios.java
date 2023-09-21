package co.edu.uniquindio.clinica.modelo.servicios;

public interface CitaServicios {

    void agendarCita();
    void listarCitasPaciente();//codigo paciente y codigo medico
    void verDetalleCita();
    void filtrarCitasPorMedicoFecha();
    void listarCitasPendientesMedico();
    void atenderCita();
    void listarTodasCitasMedico();//parametro codigo medico
}
