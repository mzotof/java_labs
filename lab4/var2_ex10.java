// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
// interface Фильм <- class Отечественный Фильм <- class Комедия.
interface Film {
    void play(); // метод для проигрывания фильма
    void stop(); // метод для остановки проигрывания фильма
}

// Абстрактный класс DomesticFilm
abstract class DomesticFilm implements Film {
    protected String title; // название фильма
    protected int duration; // продолжительность фильма в минутах

    public DomesticFilm(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}

// Класс Comedy
class Comedy extends DomesticFilm {
    private final int year;

    public Comedy(String title, int duration, int year) {
        super(title, duration);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void play() {
        // код для проигрывания комедии
        System.out.println("Проигрывается комедия \"" + title + "\" " + year +
                " года продолжительностью " + duration + " минут");
    }

    @Override
    public void stop() {
        // код для остановки проигрывания комедии
        System.out.println("Проигрывание комедии \"" + title + "\" было остановлено");
    }
}

public class var2_ex10 {
    public static void main(String[] args) {
        Comedy comedy = new Comedy("Брильянтовая рука", 98, 1968);

        comedy.play();

        comedy.stop();
    }
}
