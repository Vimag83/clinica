package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findAllByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findAllByCedula(correo) != null;
    }

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if (estaRepetidaCedula(medicoDTO.cedula())) {
            throw new Exception("La cédula ya se encuentra registrada");
        }
        if (estaRepetidoCorreo(medicoDTO.correo())) {
            throw new Exception("El correo ya se encuentra registrado");
        }
            Medico medico = new Medico();
            medico.setCedula(medicoDTO.cedula());
            medico.setTelefono(medicoDTO.telefono());
            medico.setNombre(medicoDTO.nombre());
            medico.setEspecialidad(medicoDTO.especialidad());
            medico.setCiudad(medicoDTO.ciudad());
            medico.setCorreo(medicoDTO.correo());
            medico.setPassword(medicoDTO.password());
            medico.setUrlFoto(medicoDTO.urlFoto());
            medico.setEstadoUsuario(EstadoUsuario.ACTIVO);

            Medico medicoNuevo = medicoRepo.save(medico);


            return medicoNuevo.getCodigo();
        }

        @Override
        public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

            Optional<Medico> opcional = medicoRepo.findById(medicoDTO.codigo());

            if (opcional.isEmpty()) {
                throw new Exception("El código " + medicoDTO.codigo() + " no existe");
            }

            Medico buscado = opcional.get();
            buscado.setCedula(medicoDTO.cedula());
            buscado.setTelefono(medicoDTO.telefono());
            buscado.setNombre(medicoDTO.nombre());
            buscado.setEspecialidad(medicoDTO.especialidad());
            buscado.setCiudad(medicoDTO.ciudad());
            buscado.setCorreo(medicoDTO.correo());
            buscado.setUrlFoto(medicoDTO.urlFoto());

            medicoRepo.save(buscado);
            return buscado.getCodigo();

        }

        @Override
        public void eliminarMedico(int codigo) throws Exception {

            Optional<Medico> opcional = medicoRepo.findById(codigo);

            if (opcional.isEmpty()) {
                throw new Exception("El código " + codigo + " no existe");
            }

            //medicoRepo.delete( buscado.get() );
            Medico buscado = opcional.get();
            buscado.setEstadoUsuario(EstadoUsuario.INACTIVO);
            medicoRepo.save( buscado );
        }

        @Override
        public List<ItemMedicoDTO> listarMedicos() throws Exception {

            List<Medico> medicos = medicoRepo.findAll();


            if (medicos.isEmpty()) {
                throw new Exception("No hay medicos registrados");
            }
            List<ItemMedicoDTO> respuesta = new ArrayList<>();

            for (Medico m : medicos) {

                respuesta.add(new ItemMedicoDTO(
                        m.getCodigo(),
                        m.getCedula(),
                        m.getNombre(),
                        m.getUrlFoto(),
                        m.getEspecialidad()));
            }
            return respuesta;
        }


        @Override
        public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {


            Optional<Medico> opcional = medicoRepo.findById(codigo);

            if (opcional.isEmpty()) {
                throw new Exception("El código " + codigo + " no existe");
            }

            Medico buscado = opcional.get();

            return new DetalleMedicoDTO(
                    buscado.getCodigo(),
                    buscado.getNombre(),
                    buscado.getCedula(),
                    buscado.getTelefono(),
                    buscado.getCorreo(),
                    new ArrayList<>(),
                    buscado.getEspecialidad(),
                    buscado.getDiaLibre(),
                    buscado.getCiudad(),
                    buscado.getPassword(),
                    buscado.getUrlFoto()
            );

        }

        @Override
        public List<ItemPQRSDTO> listarPQRS() throws Exception {

            List<Pqrs> listaPqrs = pqrsRepo.findAll();// reemplaza selec *from
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

         /*List<ItemPQRSDTO> lista = listaPqrs.stream().map( p -> new ItemPQRSDTO(
                p.getCodigo(),
                p.getEstado(),
                p.getMotivo(),
                p.getFechaCreacion(),
                p.getCita().getPaciente().getNombre()
        ) ).toList();*/

            return respuesta;
        }

        @Override
        public int responderPQRS (RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
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
        public DetallePQRSDTO verDetallePQRS ( int codigo) throws Exception {

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
        public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {


            Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

            if (opcional.isEmpty()) {
                throw new Exception("El codigo " + codigoPQRS + " no esta asociado a ningun PQRS");
            }

            Pqrs pqrs = opcional.get();
            pqrs.setEstado(estadoPQRS);

            pqrsRepo.save(pqrs);
        }

        @Override
        public List<ItemCitaAdminDTO> listarCitas () throws Exception {

            List<Cita> listaCitas = citaRepo.findAll();
            List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

            for (Cita c : listaCitas) {

                respuesta.add(new ItemCitaAdminDTO(
                        c.getCodigocita(),
                        c.getPaciente().getCedula(),
                        c.getPaciente().getNombre(),
                        c.getMedico().getNombre(),
                        c.getMedico().getEspecialidad(),
                        c.getEstadoCita(),
                        c.getFechadeAtencion()
                ));
            }
            return respuesta;
        }

    }


