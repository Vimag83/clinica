package co.edu.uniquindio.clinica.modelo.servicios;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;

import java.util.List;

public interface MedicoServicio {

    List <ItemCitaDTO> listarCitasPendientes(int codigoMedico)throws Exception;

    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;

    List <ItemCitaDTO> listarHistorialCitasPaciente(int codigoPaciente) throws Exception; //historial médico

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List <ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

    DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception;// carga todos los datos del paciente
}
