package mx.uv.listi.videojuegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class UsuarioApp {
    
    @Autowired
    IUsuario iusuario;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public Iterable<Usuario> obtenerUsuarios(){
        return iusuario.findAll();
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public java.util.Optional<Usuario> obtenerUsuario(@PathVariable Integer id){
        return iusuario.findById(id);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public void crearUsuario(@RequestBody Usuario usuario){
        iusuario.save(usuario);
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public void actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuario.setIdUsuario(id);
        iusuario.save(usuario);
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public void borrarUsuario(@PathVariable Integer id){
        iusuario.deleteById(id);
    }
}