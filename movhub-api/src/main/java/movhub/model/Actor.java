package movhub.model;

/**
 * Created by User01 on 28/08/2017.
 */
public class Actor {

    private final int id;
    private final String name;
    private final Movie[] movies;

    public Actor(int id, String name, Movie[] movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Movie[] getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Actor { "+
                "id= " + id +
                ", name="+ name +
                ", movies " + movies +
                "}";
    }
}
