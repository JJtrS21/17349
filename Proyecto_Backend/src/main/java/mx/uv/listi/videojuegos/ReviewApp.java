package mx.uv.listi.videojuegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ReviewApp {

    @Autowired
    IReview ireview;

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> obtenerReviews() {
        return ireview.findAll();
    }

    @RequestMapping(value = "/reviews/{idJuego}/{idUsuario}", method = RequestMethod.GET)
    public java.util.Optional<Review> obtenerReview(
            @PathVariable Integer idJuego,
            @PathVariable Integer idUsuario) {
        ReviewId id = new ReviewId(idJuego, idUsuario);
        return ireview.findById(id);
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
    public void crearReview(@RequestBody Review review) {
        ireview.save(review);
    }

    @RequestMapping(value = "/reviews/{idJuego}/{idUsuario}", method = RequestMethod.PUT)
    public void actualizarReview(
            @PathVariable Integer idJuego,
            @PathVariable Integer idUsuario,
            @RequestBody Review review) {
        review.setIdJuego(idJuego);
        review.setIdUsuario(idUsuario);
        ireview.save(review);
    }

    @RequestMapping(value = "/reviews/{idJuego}/{idUsuario}", method = RequestMethod.DELETE)
    public void borrarReview(
            @PathVariable Integer idJuego,
            @PathVariable Integer idUsuario) {
        ReviewId id = new ReviewId(idJuego, idUsuario);
        ireview.deleteById(id);
    }
}
