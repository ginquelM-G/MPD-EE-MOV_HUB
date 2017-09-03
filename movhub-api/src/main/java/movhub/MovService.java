package movhub;

import movhub.data.MovhubWebApi;
import movhub.data.dto.MovieDetailsDto;
import movhub.model.Actor;
import movhub.model.Movie;
import movhub.model.MovieDetails;
import util.HttpRequest;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

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

    protected Movie dtoToMovie(){

        return null;
    }




    public CompletableFuture<Stream<MovieDetails>> movieDetails(int id){
        return api.searchMovie2(id)
                .thenApply(str -> str
                    .map(dto -> dtoToMovieDetails(dto)));
    }

//    MovieDetails(int id, String original_title,
//                 String tagline,
//                 String overview,
//                 double vote_average,
//                 String release_date,
//                 CompletableFuture<CastItem[]> cast) {

    protected MovieDetails dtoToMovieDetails(MovieDetailsDto movieDetails){
        return new MovieDetails(
                movieDetails.id(),
                movieDetails.getOriginalTitle(),
                movieDetails.getTagline(),
                movieDetails.getOverview(),
                movieDetails.getVoteAverage(),
                movieDetails.getReleaseDate(),
                null);

    }



    public CompletableFuture<Actor> actor(int id, String name){
        return null;
    }
}
