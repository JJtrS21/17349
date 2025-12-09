package mx.uv.listi.videojuegos;

import org.springframework.data.repository.CrudRepository;

public interface IReview extends CrudRepository<Review, ReviewId> {

}