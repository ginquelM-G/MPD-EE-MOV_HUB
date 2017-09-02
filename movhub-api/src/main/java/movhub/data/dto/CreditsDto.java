package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class CreditsDto {

    public final CastItemDto[] cast;

    public CreditsDto(CastItemDto[] cast){
        this.cast = cast;
    }

    public CastItemDto[] getCast(){
        return cast;
    }

    @Override
    public String toString() {
        StringBuilder stB = new StringBuilder();
        for(CastItemDto s: cast)
            stB.append(s).append("\n");

        return "castItemDtos {" + stB.toString() + "}";
    }
}
