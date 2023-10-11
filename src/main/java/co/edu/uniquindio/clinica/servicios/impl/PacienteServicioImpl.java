package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final CitaRepo citaRepo;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;


    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCedula(correo) != null;
    }


    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        Paciente paciente = new Paciente();

        if (estaRepetidaCedula(pacienteDTO.cedula())) {
            throw new Exception("La cédula ya se encuentra registrada");
        }
        if (estaRepetidoCorreo(pacienteDTO.correo())) {
            throw new Exception("El correo ya se encuentra registrado");
        }
//Datos de la Cuenta
            paciente.setCorreo(pacienteDTO.correo());
            paciente.setPassword(pacienteDTO.password());
//Datos del Usuario
            paciente.setNombre(pacienteDTO.nombre());
            paciente.setCedula(pacienteDTO.cedula());
            paciente.setTelefono(pacienteDTO.telefono());
            paciente.setCiudad(pacienteDTO.ciudad());
            paciente.setUrlFoto(pacienteDTO.urlFoto());
//Datos del Paciente
            paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
            paciente.setEps(pacienteDTO.eps());
            paciente.setAlergias(pacienteDTO.alergias());
            paciente.setTipoSangre(pacienteDTO.tipoSangre());
            Paciente pacienteCreado = pacienteRepo.save(paciente);
            return pacienteCreado.getCodigo();
        }

        @Override
        public int editarPerfil (DetallePacienteDTO pacienteDTO) throws Exception {


            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(pacienteDTO.codigo());

            if (pacienteBuscado.isEmpty()) {
                throw new Exception("No existe un paciente con el código " + pacienteDTO.codigo());
            }

            Paciente paciente = pacienteBuscado.get();
            //Datos de la Cuenta
            paciente.setCorreo(pacienteDTO.correo());
            //Datos del Usuario
            paciente.setNombre(pacienteDTO.nombre());
            paciente.setCedula(pacienteDTO.cedula());
            paciente.setTelefono(pacienteDTO.telefono());
            paciente.setCiudad(pacienteDTO.ciudad());
            paciente.setUrlFoto(pacienteDTO.urlFoto());
            //Datos del Paciente
            paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
            paciente.setEps(pacienteDTO.eps());
            paciente.setAlergias(pacienteDTO.alergias());
            paciente.setTipoSangre(pacienteDTO.tipoSangre());
            /*Como el objeto paciente ya tiene un id, el save() no crea un nuevo registro sino que
                     actualiza el que ya existe*/
            pacienteRepo.save(paciente);
            return paciente.getCodigo();
        }
        @Override
        public void eliminarCuenta ( int codigo) throws Exception {

            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);

            if (pacienteBuscado.isEmpty()) {
                throw new Exception("No existe un paciente con el código " + codigo);
            }
            pacienteRepo.delete(pacienteBuscado.get());
        }
        @Override
        public DetallePacienteDTO verDetallePaciente ( int codigo) throws Exception {

            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);

            if (pacienteBuscado.isEmpty()) {
                throw new Exception("No existe un paciente con el código " + codigo);
            }

            Paciente paciente = pacienteBuscado.get();

//Hacemos un mapeo de un objeto de tipo Paciente a un objeto de tipo DetallePacienteDTO
            return new DetallePacienteDTO(
                    paciente.getCodigo(),
                    paciente.getNombre(),
                    paciente.getCedula(),

                    paciente.getTelefono(),
                    paciente.getUrlFoto(),
                    paciente.getFechaNacimiento(),
                    paciente.getAlergias(),
                    paciente.getCorreo(),
                    paciente.getCiudad(),
                    paciente.getEps(),
                    paciente.getTipoSangre());


        }
        @Override
        public List<ItemPacienteDTO> listarTodos () {

            List<Paciente> pacientes = pacienteRepo.findAll();
            List<ItemPacienteDTO> repuesta = new ArrayList<>();
//Hacemos un mapeo de cada uno de los objetos de tipo Paciente a objetos de tipo ItemPacienteDTO
            for (Paciente paciente : pacientes) {
                repuesta.add(new ItemPacienteDTO(paciente.getCodigo(), paciente.getCedula(),
                        paciente.getNombre(), paciente.getCiudad()));
            }
            return repuesta;
        }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NuevoPasswordDTO nuevoPasswordDTO) throws Exception {

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(registroPQRSDTO.codigoPaciente());
        Optional<Cita> citaOptional = citaRepo.findById(registroPQRSDTO.codigoCita());
        long countPQRSActivas = pqrsRepo.countByPacienteCodigoAndEstado(registroPQRSDTO.codigoPaciente(), "Activa");

        Pqrs pqrs = new Pqrs();
        pqrs.setTipo(registroPQRSDTO.tipoPQRS());
        pqrs.setMotivo(registroPQRSDTO.motivo());
        new ArrayList<>();
        pqrs.setEstado(EstadoPQRS.ABIERTA);

        Pqrs nuevaPqrs = pqrsRepo.save(pqrs);
        return nuevaPqrs.getCodigoPqrs();
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<Pqrs> listaPqrs = pqrsRepo.findAllByCita_PacienteCodigo(codigoPaciente);// reemplaza selec *from
        List<ItemPQRSDTO> respuesta = new ArrayList<>();


        for (Pqrs p : listaPqrs) {
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigoPqrs(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()

            ));
        }


        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);

        if (opcional.isEmpty()) {

            throw new Exception("El codigo " + codigo + " no esta asociado a ningun PQRS");
        }

        Pqrs pqrs = opcional.get();

        return new DetallePQRSDTO(

                pqrs.getCodigoPqrs(),
                pqrs.getEstado(),
                pqrs.getMotivo(),
                pqrs.getCita().getPaciente().getNombre(),
                pqrs.getCita().getMedico().getNombre(),
                pqrs.getCita().getMedico().getEspecialidad(),
                pqrs.getFechaCreacion(),
                new ArrayList<>()
        );
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        // Se Obtiene el PQRS
        Optional<Pqrs> opcionalPqrs = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if (opcionalPqrs.isEmpty()) {
            throw new Exception("El codigo" + registroRespuestaDTO.codigoPQRS() + "no esta asociado a ningun PQRS");
        }
        // Se Obtiene la cuenta
        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if (opcionalCuenta.isEmpty()) {
            throw new Exception("El codigo" + registroRespuestaDTO.codigoCuenta() + "no esta asociado a ninguna cuenta");
        }

        Mensaje mensaje = new Mensaje();
        mensaje.setFechaCreacion(LocalDateTime.now());
        mensaje.setContenido(registroRespuestaDTO.mensaje());
        mensaje.setPqrs(opcionalPqrs.get());
        mensaje.setCuenta(opcionalCuenta.get());

        return mensajeRepo.save(mensaje).getCodigo();
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        List<Cita> listaCitasPaciente = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita c : listaCitasPaciente ){
            respuesta.add(new ItemCitaAdminDTO(
                    c.getCodigocita(),
                    c.getPaciente().getNombre(),
                    c.getPaciente().getCedula(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechadeAtencion()

            ));
        }
        return respuesta;
    }

    @Override
    public void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception {
        return null;
    }

}






