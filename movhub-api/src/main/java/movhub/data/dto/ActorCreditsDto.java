package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class ActorCreditsDto {

    public final MovieSearchItemDto[] movieSearchItemDtos;

    public ActorCreditsDto(MovieSearchItemDto[] movieSearchItemDtos){
        this.movieSearchItemDtos = movieSearchItemDtos;
    }

    public MovieSearchItemDto[] getCast(){
        return movieSearchItemDtos;
    }


}
