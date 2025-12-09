package mx.uv.listi.videojuegos;

import java.io.Serializable;

public class ReviewId implements Serializable {
    private Integer idJuego;
    private Integer idUsuario;

    public ReviewId() {}

    public ReviewId(Integer idJuego, Integer idUsuario) {
        this.idJuego = idJuego;
        this.idUsuario = idUsuario;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}