package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovieSearchDto {

    public final MovieSearchItemDto[] movieSearchItemDtos;

    public MovieSearchDto(MovieSearchItemDto[] movieSearchItemDtos){
        this.movieSearchItemDtos = movieSearchItemDtos;
    }

    public MovieSearchItemDto[] getResults(){
        return movieSearchItemDtos;
    }

}
