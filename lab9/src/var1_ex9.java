import java.util.Arrays;
import java.util.Collection;

// Задана коллекция строк. Вернуть количество вхождений строки.

public class var1_ex9 {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("hello", "world", "hello", "java", "world");
        long count = strings.stream().filter(str -> str.equals("hello")).count();
        System.out.println(count);
    }
}
