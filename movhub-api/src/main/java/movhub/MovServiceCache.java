package movhub;

import movhub.data.MovhubWebApi;
import movhub.model.Actor;
import movhub.model.Movie;
import movhub.model.MovieDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

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


    private final Map<Integer,CompletableFuture<MovieDetails>> cacheMovieDetailsMap = new HashMap<>();
    private final Map<Integer, CompletableFuture<Actor>> actorMap = new HashMap<>();


    public MovServiceCache(MovhubWebApi api){
        super(api);
    }


    public CompletableFuture<Movie[]> search(String name, int page) {
        return  null;
    }

    public CompletableFuture<Stream<MovieDetails>> movieDetails(int id){
//        if (id == 0) id = 293660;
//        CompletableFuture<MovieDetails> movieDetailsCF = getOrCreate(id, cacheMovieDetailsMap);
//
//        Gson gson = new Gson();
//        String uri2 = String.format("https://api.themoviedb.org/3/movie/%d?api_key=629fc6979bdef5c207d398578144c126", id);
//
//        IRequest req = new HttpRequest();
//        Iterable<String> body = req.getContent(uri2);
//        String json = join(body);
////        System.out.println("\n\n\nJSON:\n" + json + "\n\n");
//        MovieDetailsDto movieDetailsDto = gson.fromJson(json, MovieDetailsDto.class);
//        System.out.println( movieDetailsDto);


        return null;
    }

    public CompletableFuture<Actor> actor(int id, String name){
        return null;
    }



    private static CompletableFuture<MovieDetails> getOrCreate(int id, Map<Integer,CompletableFuture<MovieDetails>> cacheMovieDetailsMap){
        CompletableFuture<MovieDetails> movDetails = cacheMovieDetailsMap.get(id);
        try {
            if(movDetails == null || movDetails.get() == null){
                movDetails = CompletableFuture.supplyAsync(() -> null);
                cacheMovieDetailsMap.put(id, movDetails);
            }

            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return movDetails;
    }

}
