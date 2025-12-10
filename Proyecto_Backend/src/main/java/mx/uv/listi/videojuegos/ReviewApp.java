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
public class ReviewApp {
    
    @Autowired
    IReview ireview;

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> obtenerReviews(){
        return ireview.findAll();
    }

    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
    public java.util.Optional<Review> obtenerReview(@PathVariable Integer id){
        return ireview.findById(id);
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
    public void crearReview(@RequestBody Review review){
        ireview.save(review);
    }

    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.PUT)
    public void actualizarReview(@PathVariable Integer id, @RequestBody Review review){
        review.setIdReview(id);
        ireview.save(review);
    }

    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.DELETE)
    public void borrarReview(@PathVariable Integer id){
        ireview.deleteById(id);
    }
}
