package mx.uv.listi.videojuegos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> obtenerUsuarios(){
        try {
            System.out.println("=== INTENTANDO OBTENER USUARIOS ===");
            Iterable<Usuario> usuarios = iusuario.findAll();
            
            // Convertir a lista para forzar la ejecución
            List<Usuario> lista = new ArrayList<>();
            for (Usuario u : usuarios) {
                System.out.println("Usuario encontrado: " + u.getNombre());
                lista.add(u);
            }
            
            System.out.println("=== ÉXITO: " + lista.size() + " usuarios ===");
            return ResponseEntity.ok(lista);
            
        } catch (Exception e) {
            System.err.println("=== ERROR EN /usuarios ===");
            e.printStackTrace();  // Esto irá a los logs de Railway
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Causa: " + (e.getCause() != null ? e.getCause().getMessage() : "N/A"));
            
            return ResponseEntity.status(500)
                .body("Error interno: " + e.getClass().getSimpleName() + 
                     " - " + e.getMessage());
        }
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