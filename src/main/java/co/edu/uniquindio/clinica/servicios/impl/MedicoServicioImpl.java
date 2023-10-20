package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.enums.EstadoCita;
import co.edu.uniquindio.clinica.modelo.entidades.Atencion;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.OrdenMedica;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.AtencionRepo;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;

    @Override
    public List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citasPendientes = citaRepo.findAllByMedicoCodigoAndEstadoCita(codigoMedico, EstadoCita.PENDIENTE);

        if (citasPendientes.isEmpty()) {
            throw new Exception("No hay citas pendientes para este médico.");
        }

        // Crear una lista de DTO para las citas pendientes
        List<ItemCitaAdminDTO> citasDTO = new ArrayList<>();

        for (Cita cita : citasPendientes) {
            citasDTO.add(new ItemCitaAdminDTO(
                    cita.getCodigoCita(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre(),
                    cita.getMedico().getNombre(),
                    cita.getMedico().getEspecialidad(),
                    cita.getEstadoCita(),
                    cita.getFechadeAtencion()
            ));
        }
        return citasDTO;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {

        List<OrdenMedica> listaOrdenesMedicas = new ArrayList<>();

        // Obtener la cita por su código
        Cita cita = citaRepo.findAllByCodigoCita(registroAtencionDTO.codigoCita());

        // Obtener los datos del paciente asociado a la cita
        Paciente paciente = cita.getPaciente();

        // Registrar la atención médica
        Atencion atencion = new Atencion();
        atencion.setCita(cita);
        atencion.setDiagnostico(registroAtencionDTO.diagnostico());
        atencion.setTratamiento(registroAtencionDTO.tratamiento());
        atencion.setNotasMedicas(registroAtencionDTO.notasMedicas());

        // Aquí debes ajustar cómo asignar el objeto OrdenMedica al Atencion, ya que no es una lista.
        // Por ejemplo:
        OrdenMedica ordenMedica = registroAtencionDTO.ordenMedica();
        listaOrdenesMedicas.add(ordenMedica);
        atencion.setOrdenesMedicas(listaOrdenesMedicas);

        // Guardar la atención médica en la base de datos
        atencionRepo.save(atencion);

        return atencion.getCodigo();

    }

    @Override
    public List<ItemCitaAdminDTO> listarHistorialCitasPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {

        List<Cita> citasRealizadas = citaRepo.findAllByMedicoCodigoAndEstadoCita(codigoMedico, EstadoCita.COMPLETADA);

        if (citasRealizadas.isEmpty()) {
            throw new Exception("No hay citas pendientes para este médico.");
        }

        // Crear una lista de DTO para las citas pendientes
        List<ItemCitaAdminDTO> citasDTO = new ArrayList<>();

        for (Cita cita : citasRealizadas) {
            citasDTO.add(new ItemCitaAdminDTO(
                    cita.getCodigoCita(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre(),
                    cita.getMedico().getNombre(),
                    cita.getMedico().getEspecialidad(),
                    cita.getEstadoCita(),
                    cita.getFechadeAtencion()
            ));
        }
        return citasDTO;

    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception {
        return null;
    }
}
