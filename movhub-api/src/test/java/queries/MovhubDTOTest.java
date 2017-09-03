package queries;

import com.google.gson.Gson;
import movhub.data.dto.ActorCreditsDto;
import movhub.data.dto.CreditsDto;
import movhub.data.dto.MovieDetailsDto;
import movhub.data.dto.MovieSearchDto;
import org.junit.Test;
import util.HttpRequest;
import util.IRequest;

import static org.junit.Assert.assertNotNull;
import static util.queries.LazyQueries.join;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovhubDTOTest {

    @Test
    public void test_MovieSearcDto() {
        Gson gson = new Gson();
        String uri = "https://api.themoviedb.org/3/search/movie?query=Deadpool&api_key=629fc6979bdef5c207d398578144c126";

        IRequest req = new HttpRequest();
        Iterable<String> body = req.getContent(uri);

        //  body.forEach(System.out::println);
        String json = join(body);
        //System.out.println("\n\n\nJSON:\n" + json + "\n\n");

        MovieSearchDto dto = gson.fromJson(json, MovieSearchDto.class);
     //        ActorCreditsDto dto1 = gson.fromJson(json, ActorCreditsDto.class);
         MovieDetailsDto movieDetailsDto = gson.fromJson(json, MovieDetailsDto.class);
         System.out.println("\n\n" + dto);
        assertNotNull(movieDetailsDto);
    }


    @Test
    public void test_MovieDetailsDto() {
        Gson gson = new Gson();
        String uri2 = "https://api.themoviedb.org/3/movie/293660?api_key=629fc6979bdef5c207d398578144c126";
        String uri3 = "https://api.themoviedb.org/3/movie/293660/credits?api_key=629fc6979bdef5c207d398578144c126";
        String uri4 = "https://api.themoviedb.org/3/person/10859/movie_credits?api_key=629fc6979bdef5c207d398578144c126";
        IRequest req = new HttpRequest();
        Iterable<String> body = req.getContent(uri2);

        //  body.forEach(System.out::println);
        String json = join(body);
        System.out.println("\n\n\nJSON:\n" + json + "\n\n");

        MovieDetailsDto movieDetailsDto = gson.fromJson(json, MovieDetailsDto.class);
        System.out.println( movieDetailsDto);

        assertNotNull(movieDetailsDto);

    }


    @Test
    public void test_CreditsDto() {
        Gson gson = new Gson();
        String uri3 = "https://api.themoviedb.org/3/movie/293660/credits?api_key=629fc6979bdef5c207d398578144c126";
        IRequest req = new HttpRequest();
        Iterable<String> body = req.getContent(uri3).get();

        String json = join(body);
       // System.out.println("\n\n\nJSON:\n" + json + "\n\n");

        CreditsDto creditsDto = gson.fromJson(json, CreditsDto.class);
//        CastItemDto castItemDto = gson.fromJson(json, CastItemDto.class);
        System.out.println( creditsDto);
//        System.out.println("\n\n"+ castItemDto);

        assertNotNull(creditsDto);
//        assertNotNull(castItemDto);

    }


    @Test
    public void test_ActorCreditsDto() {
        Gson gson = new Gson();
        String uri4 = "https://api.themoviedb.org/3/person/10859/movie_credits?api_key=629fc6979bdef5c207d398578144c126";
        IRequest req = new HttpRequest();
        Iterable<String> body = req.getContent(uri4);

        String json = join(body);

        ActorCreditsDto actorCreditsDto = gson.fromJson(json, ActorCreditsDto.class);
        System.out.println( actorCreditsDto);
        assertNotNull(actorCreditsDto);
    }


}
