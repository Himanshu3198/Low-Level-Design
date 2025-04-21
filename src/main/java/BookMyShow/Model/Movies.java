package BookMyShow.Model;

public class Movies {
    private final String movieId;
    private final String title;
    private final String genre;
    private final String cast;

    @Override
    public String toString() {
        return "Movies{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", cast='" + cast + '\'' +
                '}';
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getCast() {
        return cast;
    }

    public Movies(String movieId, String title, String genre, String cast) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.cast = cast;
    }
}
