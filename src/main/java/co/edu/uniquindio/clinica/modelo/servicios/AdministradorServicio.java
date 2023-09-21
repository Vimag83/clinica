package co.edu.uniquindio.clinica.modelo.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;

import java.util.List;

public interface AdministradorServicio {

    String crearMedico(MedicoDTO medico) throws Exception;

    String actualizarMedico(int codigo, MedicoDTO medico) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<MedicoDTOAdmin> listarMedicos() throws Exception;

    InfoMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<PQRSDTOAdmin> listarPQRS() throws Exception;

    String responderPQRS(int codigo) throws Exception;

    InfoPQRSDTO verDetallePQRS(int codigo) throws Exception;

    List<CitaDTOAdmin> listarCitas() throws Exception;
}
