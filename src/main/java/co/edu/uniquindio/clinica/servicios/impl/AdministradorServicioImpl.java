package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.MensajeRepo;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private  final MensajeRepo mensajeRepo;

   /* public AdministradorServicioImpl(MedicoRepo medicoRepo, PQRSRepo pqrsRepo) {


        this.medicoRepo = medicoRepo;
        this.pqrsRepo = pqrsRepo;
    }*/

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        Medico medico = new Medico();
        medico.setCedula(medicoDTO.cedula() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre() );
        medico.setEspecialidad( medicoDTO.especialidad() );
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo() );
        medico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setEstado(EstadoUsuario.ACTIVO);

        Medico medicoNuevo = medicoRepo.save(medico);


        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {


        Optional<Medico> opcional = medicoRepo.findById(medicoDTO.codigo());

        if(opcional.isEmpty() ){
            throw new Exception("El código "+medicoDTO.codigo()+" no existe");
        }

        Medico buscado = opcional.get();
        buscado.setCedula(medicoDTO.cedula() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre() );
        buscado.setEspecialidad( medicoDTO.especialidad() );
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setCorreo(medicoDTO.correo() );
        buscado.setUrlFoto(medicoDTO.urlFoto());

        medicoRepo.save(buscado);
        return buscado.getCodigo();

    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

        Optional<Medico> opcional = medicoRepo.findById(codigo);

        if(buscado.isEmpty() ){
            throw new Exception("El código "+codigo+" no existe");
        }

        //medicoRepo.delete( buscado.get() );
        Medico obtenido = buscado.get();
        obtenido.setEstado( false );

        medicoRepo.save(obtenido);

    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico>medicos = medicoRepo.findAll();
        
        
        if)medicos.isEmpty()){
    throw  new Exception("No hay medicos registrados");
        }
        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for(Medico m : medicos){
            
                respuesta.add(new ItemMedicoDTO(
                        m.getCodigo(),
                        m.getCedula(),
                        m.getNombre(),
                        m.getUrlFoto(),
                        m.getEspecialidad()));
            }
        }

        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {


        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if(buscado.isEmpty() ){
            throw new Exception("El código "+codigo+" no existe");
        }

        Medico obtenido = buscado.get();

        DetalleMedicoDTO detalleMedicoDTO = new DetalleMedicoDTO(
                obtenido.getCodigo(),
                obtenido.getNombre(),
                obtenido.getCedula(),
                obtenido.getCiudad(),
                obtenido.getEspecialidad(),
                obtenido.getTelefono(),
                obtenido.getCorreo(),
                obtenido.getUrlFoto(),
                new ArrayList<>()
        );

        return detalleMedicoDTO;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

     List<Pqrs> listaPqrs = pqrsRepo.findAll();
     List<ItemPQRSDTO> respuesta = new ArrayList<>();


    for (Pqrs p : listaPqrs) {
        respuesta.add(new ItemPQRSDTO(
                p.getCodigo(),
                p.getEstado(),
                p.getMotivo(),
                p.getFechaCreacion(),
                p.getCita().getPaciente().getNombre(),

        ));
    }


        return respuesta;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Mensaje mensaje = new Mensaje();
        mensaje.setFe

        return 0;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {

    Optional<Pqrs> opcional = pqrsRepo.findById(codigo);

    if(opcional.isEmpty() ) {

        throw  new Exception("El codigo "+codigo+" no esta asociado a ningun PQRS");
    }

    Pqrs pqrs = opcional.get();

    return  new DetallePQRSDTO(

            pqrs.getCodigo(),
            pqrs.getEstado(),
            pqrs.getMotivo(),
            pqrs.getCita().getPaciente().getNombre(),
            pqrs.getCita().getMedico().getNombre(),
            pqrs.getCita().getMedico.getEspecialidad(),
            pqrs.getFechaCreacion(),
            new ArrayList<>()


    );
    }

    @Override
    public List<ItemCitaDTO> listarCitas() throws Exception {
        return null;
    }
}
