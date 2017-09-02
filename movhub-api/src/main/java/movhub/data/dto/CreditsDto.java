package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class CreditsDto {

    public final CastItemDto[] castItemDtos;

    public CreditsDto(CastItemDto[] castItemDtos){
        this.castItemDtos = castItemDtos;
    }

    public CastItemDto[] getCast(){
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                "castItemDtos=" + castItemDtos +
                "}";
    }
}
