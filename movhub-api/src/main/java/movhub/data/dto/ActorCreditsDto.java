package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class ActorCreditsDto {

    public final MovieSearchItemDto[] results;

    public ActorCreditsDto(MovieSearchItemDto[] movieSearchItemDtos){
        this.results = movieSearchItemDtos;
    }

    public MovieSearchItemDto[] getCast(){
        return results;
    }


}
