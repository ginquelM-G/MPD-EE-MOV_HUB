package movhub.data;

import com.google.gson.Gson;
import movhub.data.dto.MovieDetailsDto;
import movhub.data.dto.MovieSearchDto;
import movhub.model.Movie;
import util.IRequest;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Created by User01 on 28/08/2017.
 */
public class MovhubWebApi implements AutoCloseable{

    /*
        key = 629fc6979bdef5c207d398578144c126
         https://api.themoviedb.org/3/search/movie?api_key=*****&query=war+games
         https://api.themoviedb.org/3/movie/860?api_key=*****
         https://api.themoviedb.org/3/movie/860/credits?api_key=*****
         https://api.themoviedb.org/3/person/4756/movie_credits?api_key=*****
    */

    private static final String MOVHUB_TOKEN;
    private static final String MOVHUB_HOST = "https://api.themoviedb.org";//"https://developers.themoviedb.org/3/";
    private static final String MOVHUB_SEARCH_MOVIE ="/3/search/movie?query=%s";
    private static final String MOVHUB_SEARCH_MOVIE_ARGS ="&api_key=%s";

    private static final String MOVHUB_MOVIE ="/3/movie/%d?";
    private static final String MOVHUB_MOVIE_ARGS ="api_key=%s";



    static{
        try{
            URL keyFile = ClassLoader.getSystemResource("movhub-app-key.txt");
            if(keyFile == null){
                throw  new IllegalStateException("YOU MUST GOT a KEY in https://api.themoviedb.org and place it in src/main/resoures/");
            }else {
                InputStream keyStream = keyFile.openStream();
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(keyStream))){
                    MOVHUB_TOKEN = reader.readLine();
                }
            }

        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }



    private final IRequest req;

    public MovhubWebApi(IRequest req){this.req = req;}


    /**
     *  https://api.themoviedb.org/3/search/movie?api_key=629fc6979bdef5c207d398578144c126&query=war+games
     */
     public CompletableFuture<Stream<MovieSearchDto>> searchMovie(String  query){


         String path = MOVHUB_HOST + MOVHUB_SEARCH_MOVIE + MOVHUB_SEARCH_MOVIE_ARGS;
         String url = String.format(path, query, MOVHUB_TOKEN);

         System.out.println("\n\nSearchMovie path:\n"+ url);

         List<Movie> res = new ArrayList<>();
         CompletableFuture<Stream<String>> iter = req.getContent(path);

         System.out.println("\n\n CompletableFuture<Stream<String>>:\n"+  iter);
//         while(iter.hasNext()){
//             String line = iter.next();
//             res.add(Movie.valueOf(line));
//         }

//         return req.getContent(url)
//                 .thenApply(str -> str
//                    .map(MovieSearchDto::));
         return null;
    }


    /**
     *  https://api.themoviedb.org/3/search/movie?api_key=629fc6979bdef5c207d398578144c126&query=war+games
     */
    public CompletableFuture<Stream<MovieDetailsDto>> searchMovie2(int  movieId){
        Gson gson = new Gson();
        String path = MOVHUB_HOST + MOVHUB_MOVIE + MOVHUB_MOVIE_ARGS;
        String url = String.format(path, movieId, MOVHUB_TOKEN);

        System.out.println("\n\nSearchMovie path:\n"+ url);

        List<Movie> res = new ArrayList<>();
        CompletableFuture<Stream<String>> iter = req.getContent(url);

        System.out.println("\n\n CompletableFuture<Stream<String>>:\n"+  iter);
//         while(iter.hasNext()){
//             String line = iter.next();
//             res.add(Movie.valueOf(line));
//         }

     //   gson.fromJson(str, MovieDetailsDto.class)

         return req.getContent(url)
                 .thenApply(str -> {
                     System.out.println("\n" + str);
                     return str.map(command -> gson.fromJson(command, MovieDetailsDto.class));
                 });

//        return null;
    }


    @Override
    public void close() throws Exception {
        req.close();
    }
}
