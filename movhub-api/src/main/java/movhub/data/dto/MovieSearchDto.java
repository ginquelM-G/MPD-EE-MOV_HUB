package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovieSearchDto {

    public final MovieSearchItemDto[] results;

    public MovieSearchDto(MovieSearchItemDto[] results){
        this.results = results;
    }

    public MovieSearchItemDto[] getResults(){
        return results;
    }

}
