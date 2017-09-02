package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovieSearchItemDto {
    private final int id;
    private final String title;
    private final String release_date;
    private final double vote_average;

    public MovieSearchItemDto(int id, String title, String release_date, double vote_average) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public String getTitle(){
        return title;
    }

    public int id(){
        return id;
    }

    public String getReleaseDate(){
        return release_date;
    }

    public double getVoteAverage(){
        return vote_average;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", vote_average:" + vote_average+
                ", title:" + title +
                ", release_date:" + release_date +
                "}";
    }
}
