package movhub;

import movhub.model.Movie;
import util.IRequest;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User01 on 28/08/2017.
 */
public class MovhubWebApi {

    /*
        key = 629fc6979bdef5c207d398578144c126
         https://api.themoviedb.org/3/search/movie?api_key=*****&query=war+games
         https://api.themoviedb.org/3/movie/860?api_key=*****
         https://api.themoviedb.org/3/movie/860/credits?api_key=*****
         https://api.themoviedb.org/3/person/4756/movie_credits?api_key=*****
    */

    private static final String MOVHUB_TOKEN;
    private static final String MOVHUB_HOST = "https://api.themoviedb.org/3/";//"https://developers.themoviedb.org/3/";

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
     public Iterable<Movie> searchMovie(){


         String path = MOVHUB_HOST + "search/movie?" +
                 String.format("api_key=%s&query=%s", MOVHUB_TOKEN, "Logan");

         System.out.println("\n\nSearchMovie path:\n"+ path);

         List<Movie> res = new ArrayList<>();
         Iterator<String> iter = req.getContent(path).iterator();

         while(iter.hasNext()){
             String line = iter.next();
             res.add(Movie.valueOf(line));
         }

         return null;
    }
}
