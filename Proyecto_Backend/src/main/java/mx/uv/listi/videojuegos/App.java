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
public class App {
    @Autowired
    IJuego ijuego;

    @RequestMapping(value = "/juegos", method = RequestMethod.GET)
    public Iterable<Juego> obtenerJuegos(){
        return ijuego.findAll();
    }

    @RequestMapping(value = "/juegos/{id}", method = RequestMethod.GET)
    public java.util.Optional<Juego> obtenerJuego(@PathVariable Integer id){
        return ijuego.findById(id);
    }

    @RequestMapping(value = "/juegos", method = RequestMethod.POST)
    public void crearJuego(@RequestBody Juego juego){
        ijuego.save(juego);
    }

    @RequestMapping(value = "/juegos/{id}", method = RequestMethod.PUT)
    public void actualizarJuego(@PathVariable Integer id, @RequestBody Juego juego){
        juego.setIdJuego(id);
        ijuego.save(juego);
    }

    @RequestMapping(value = "/juegos/{id}", method = RequestMethod.DELETE)
    public void borrarJuego(@PathVariable Integer id){
        ijuego.deleteById(id);
    }
}
