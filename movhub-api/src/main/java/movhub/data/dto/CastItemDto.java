package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class CastItemDto {

    private final String name;
    private final int id;
    private final String character;

    public CastItemDto(String name, int id, String character) {
        this.name = name;
        this.id = id;
        this.character = character;
    }


    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getCharacter(){
        return character;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" +id +
                ", name=" +name +
                ", character=" +character +
                "}";
//        return super.toString();
    }
}
