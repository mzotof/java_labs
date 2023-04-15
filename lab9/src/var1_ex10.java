import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Задана коллекция студентов.
// Вернуть список студентов имя которых начинается на P и рейтинг находится в интервале 40-60.

public class var1_ex10 {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Ivan", 40),
                new Student("Petr", 60),
                new Student("Olga", 70)
        );

        List<Student> result = students.stream()
                .filter(student -> student.getName().startsWith("P"))
                .filter(student -> student.getRating() >= 40 && student.getRating() <= 60)
                .toList();

        result.forEach(System.out::println);
    }
}

class Student {
    private final String name;
    private final int rating;

    public Student(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
