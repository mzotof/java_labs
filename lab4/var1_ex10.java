import java.util.ArrayList;
// Создать класс Cinema (кино) с внутренним классом, с помощью объектов которого можно хранить
// информацию об адресах кинотеатров, фильмах и времени сеансов.
class Cinema {
    private final ArrayList<String> addresses = new ArrayList<>();
    private final ArrayList<Movie> movies = new ArrayList<>();

    public void addAddress(String address) {
        addresses.add(address);
    }

    public void removeAddress(String address) {
        addresses.remove(address);
    }

    public void addMovie(String title, String director, int duration) {
        movies.add(new Movie(title, director, duration));
    }

    public void removeMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movies.remove(movie);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Адреса кинотеатров:\n");
        for (String address : this.addresses)
            res.append(address).append("\n");
        res.append("Фильмы:\n");
        for (Cinema.Movie movie : this.movies)
            res.append(movie.getTitle()).append(" (реж. ").append(movie.getDirector())
                    .append(") - ").append(movie.getDuration()).append("\n");
        return res.toString();
    }

    public static class Movie {
        private final String title;
        private final String director;
        private final int duration;

        public Movie(String title, String director, int duration) {
            this.title = title;
            this.director = director;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public String getDirector() {
            return director;
        }

        public int getDuration() {
            return duration;
        }
    }
}

public class var1_ex10 {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addAddress("ул. Ленина, 5");
        cinema.addAddress("ул. Пушкина, 10");

        cinema.addMovie("Звездные войны", "Джордж Лукас", 120);
        cinema.addMovie("Терминатор", "Джеймс Кэмерон", 108);

        System.out.println(cinema);
    }
}
