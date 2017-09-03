package movhub.data.dto;

/**
 * Created by Moreira on 02-09-2017.
 */
public class MovieDetailsDto {
    private final String tagline;
    private final int id;
    private final String original_title;
    private final String overview;
    private final String release_date;
    private final double vote_average;

    public MovieDetailsDto(){
        this.tagline = "";
        this.id = 0;
        this.original_title = "";
        this.overview = "";
        this.release_date = "";
        this.vote_average = 0;
    }
    public MovieDetailsDto(String tagline, int id, String original_title, String overview, String release_date, double vote_average) {
        this.tagline = tagline;
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public String getTagline(){
        return tagline;
    }

    public int id(){
        return id;
    }

    public String getOriginalTitle(){
        return original_title;
    }

    public String getOverview(){
        return overview;
    }

    public String getReleaseDate(){
        return release_date;
    }

    public double getVoteAverage(){
        return vote_average;
    }

    @Override
    public String toString() {
        return "MovieDetailsDto {" +
                "tagline: " + tagline +
                ", id:" + id +
                ", originalTitle:" + original_title +
                ", releaseDate: "+ release_date +
                ", voteAverage: " + vote_average +
                ", overview: "+ overview +
                "}";
//        return super.toString();
    }
}
