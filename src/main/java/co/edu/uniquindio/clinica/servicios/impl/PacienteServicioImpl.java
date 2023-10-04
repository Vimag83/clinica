package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private  final PacienteRepo pacienteRepo;


    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCedula(correo) != null;
    }


    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        Paciente paciente = new Paciente();

        if( estaRepetidaCedula(pacienteDTO.cedula()) ){
            throw new Exception("La cédula ya se encuentra registrada");
        }
        if( estaRepetidoCorreo(pacienteDTO.correo()) ){
            throw new Exception("El correo ya se encuentra registrado");
//Datos de la Cuenta
        paciente.setCorreo( pacienteDTO.correo() );
        paciente.setPassword( pacienteDTO.password() );
//Datos del Usuario
        paciente.setNombre( pacienteDTO.nombre() );
        paciente.setCedula( pacienteDTO.cedula() );
        paciente.setTelefono( pacienteDTO.telefono() );
        paciente.setCiudad( pacienteDTO.ciudad() );
        paciente.setUrlFoto( pacienteDTO.urlFoto() );
//Datos del Paciente
        paciente.setFechaNacimiento( pacienteDTO.fechaNacimiento() );
        paciente.setEps( pacienteDTO.eps() );
        paciente.setAlergias( pacienteDTO.alergias() );
        paciente.setTipoSangre( pacienteDTO.tipoSangre() );
        Paciente pacienteCreado = pacienteRepo.save( paciente );
        return pacienteCreado.getCodigo();
    }

        @Override
        public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {
            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(pacienteDTO.codigo());
            if( pacienteBuscado.isEmpty() ){
                throw new Exception("No existe un paciente con el código "+pacienteDTO.codigo());
            }
            Paciente paciente = pacienteBuscado.get();
//Datos de la Cuenta
            paciente.setCorreo( pacienteDTO.correo() );
//Datos del Usuario
            paciente.setNombre( pacienteDTO.nombre() );
            paciente.setCedula( pacienteDTO.cedula() );
            paciente.setTelefono( pacienteDTO.telefono() );
            paciente.setCiudad( pacienteDTO.ciudad() );
            paciente.setUrlFoto( pacienteDTO.urlFoto() );
//Datos del Paciente
            paciente.setFechaNacimiento( pacienteDTO.fechaNacimiento() );
            paciente.setEps( pacienteDTO.eps() );
            paciente.setAlergias( pacienteDTO.alergias() );
            paciente.setTipoSangre( pacienteDTO.tipoSangre() );
//Como el objeto paciente ya tiene un id, el save() no crea un nuevo registro sino que
            actualiza el que ya existe
            pacienteRepo.save( paciente );
            return paciente.getCodigo();
        }
        @Override
        public void eliminarCuenta(int codigo) throws Exception {
            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);
            if( pacienteBuscado.isEmpty() ){
                throw new Exception("No existe un paciente con el código "+codigo);
            }
            pacienteRepo.delete( pacienteBuscado.get() );
        }
        @Override
        public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {

            Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);
            if( pacienteBuscado.isEmpty() ){
                throw new Exception("No existe un paciente con el código "+codigo);
            }
            Paciente paciente = pacienteBuscado.get();
//Hacemos un mapeo de un objeto de tipo Paciente a un objeto de tipo DetallePacienteDTO
            return new DetallePacienteDTO( paciente.getCodigo(), paciente.getCedula(),
                    paciente.getNombre(), paciente.getTelefono(), paciente.getUrlFoto(), paciente.getCiudad(),
                    paciente.getFechaNacimiento(), paciente.getAlergias(), paciente.getEps(),
                    paciente.getTipoSangre(), paciente.getCorreo() );
        }
        @Override
        public List<ItemPacienteDTO> listarTodos(){
            List<Paciente> pacientes = pacienteRepo.findAll();
            List<ItemPacienteDTO> repuesta = new ArrayList<>();
//Hacemos un mapeo de cada uno de los objetos de tipo Paciente a objetos de tipo
            ItemPacienteDTO
            for (Paciente paciente : pacientes) {
                repuesta.add( new ItemPacienteDTO( paciente.getCodigo(), paciente.getCedula(),
                        paciente.getNombre(), paciente.getCiudad() ) );
            }
            return repuesta;
        }




}
