package movhub.model;

import java.util.concurrent.CompletableFuture;

/**
 * Created by User01 on 28/08/2017.
 */
public class MovieDetails {



    private final int id;
    private final String original_title;
    private final String tagline;
    private final String overview;
    private final double vote_average;
    private final String release_date;
    private final CompletableFuture<CastItem[]> cast;



    public MovieDetails(int id, String original_title, String tagline, String overview, double vote_average, String release_date, CompletableFuture<CastItem[]> cast) {
        this.id = id;
        this.original_title = original_title;
        this.tagline = tagline;
        this.overview = overview;
        this.vote_average = vote_average;
        this.release_date = release_date;
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public String getTagline() {
        return tagline;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public CompletableFuture<CastItem[]> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return "MovieDetails - " + super.toString();
    }
}
