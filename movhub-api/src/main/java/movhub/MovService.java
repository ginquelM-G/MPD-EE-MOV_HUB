package movhub;

import movhub.data.MovhubWebApi;
import movhub.model.Actor;
import movhub.model.Movie;
import movhub.model.MovieDetails;
import util.HttpRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovService {



    private final MovhubWebApi api;

    public MovService(MovhubWebApi api){this.api = api;}

    public MovService(){api = new MovhubWebApi(new HttpRequest());}



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
