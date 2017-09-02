package movhub;

import movhub.data.MovhubWebApi;
import movhub.model.Actor;
import movhub.model.Movie;
import movhub.model.MovieDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovServiceCache extends MovService {
    /**
     *As instâncias de MovieDetails e Actor devem ser mantidas numa cache em memória do tipo
     Map<Integer,CompletableFuture<MovieDetails>> e Map<Integer, CompletableFuture<Actor>>. Os métodos
     movieDetails() e actor(), devem consultar em primeiro lugar a cache antes de realizarem um pedido à fonte de
     dados.
     */


    private final Map<Integer,CompletableFuture<MovieDetails>> movieDetailsMap = new HashMap<>();
    private final Map<Integer, CompletableFuture<Actor>> actorMap = new HashMap<>();


    public MovServiceCache(MovhubWebApi api){
        super(api);
    }


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
