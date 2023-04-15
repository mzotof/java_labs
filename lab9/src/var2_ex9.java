import java.util.Arrays;
import java.util.Collection;

// Задана коллекция чисел. С помощью метода reduce вернуть максимум и минимум.

public class var2_ex9 {
    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(10, 5, 7, 3, 12, 8);

        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        int min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
