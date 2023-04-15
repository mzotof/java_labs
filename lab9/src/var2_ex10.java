import java.util.Arrays;
import java.util.Collection;

// Задана коллекция чисел. С помощью метода reduce вернуть сумму чисел, которые > 10

public class var2_ex10 {
    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(10, 5, 20, 3, 12, 8);

        int sum = numbers.stream().filter(number -> number > 10).reduce(0, Integer::sum);

        System.out.println("Sum: " + sum);
    }
}
