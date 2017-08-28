package movhub.model;

import java.util.concurrent.CompletableFuture;

/**
 * Created by User01 on 28/08/2017.
 */
public class CastItem {

    private final int id;
    private final int movieId;
    private final String character;
    private final String name;
    private final CompletableFuture<Actor> actor;


    public CastItem(int id, int movieId, String character, String name, CompletableFuture<Actor> actor) {
        this.id = id;
        this.movieId = movieId;
        this.character = character;
        this.name = name;
        this.actor = actor;
    }



    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    public CompletableFuture<Actor> getActor() {
        return actor;
    }


    @Override
    public String toString() {
        return "CastItem - " + super.toString();
    }
}
