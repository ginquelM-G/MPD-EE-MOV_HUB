package movhub.model;

import java.util.function.Supplier;

/**
 * Created by User01 on 28/08/2017.
 */
public class Movie {

    private final int id;
    private final String title;
    private final String release_date;
    private final double vote_average;
    private final Supplier<MovieDetails> details;



    public Movie(int id, String title, String release_date, double vote_average, Supplier<MovieDetails> details) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public MovieDetails getDetails() {
        return details.get();
    }

    @Override
    public String toString() {
        return "Movie " + super.toString();
    }
}
