package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class ActorCreditsDto {

    public final MovieSearchItemDto[] cast;

    public ActorCreditsDto(MovieSearchItemDto[] cast){
        this.cast = cast;
    }

    public MovieSearchItemDto[] getCast(){
        return cast;
    }


}
