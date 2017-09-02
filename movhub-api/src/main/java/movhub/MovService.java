package movhub;

import movhub.model.Actor;
import movhub.model.Movie;
import movhub.model.MovieDetails;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovService {

    public CompletableFuture<Movie[]> search(String name, int page) {
        return  null;
    }

    public CompletableFuture<MovieDetails> movieDetails(int id){
        return null;
    }

    public CompletableFuture<Actor> actor(int id, String name){
        return null;
    }
}
