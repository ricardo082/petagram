package castro.ricardo.com.petagram;

/**
 * Created by Ricardo Castro Tapia on 5/01/2017.
 */

public class Mascota {

    private int foto;
    private String nombre;
    private int likes;

    public Mascota(int foto, String nombre, int likes) {
        this.foto= foto;
        this.nombre = nombre;
        this.likes = likes;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


}
