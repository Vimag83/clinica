package co.edu.uniquindio.clinica.servicios.interfaces;
import java.util.List;
import co.edu.uniquindio.clinica.modelo.entidades.Usuario;

public interface UsuarioServicio {

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorId(int id);

    void agregarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(int id);

    boolean existeUsuario(int id);
}
