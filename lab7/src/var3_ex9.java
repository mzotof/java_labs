import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Напечатать слова русского текста в алфавитном порядке по первой букве.
// Слова, начинающиеся с новой буквы, печатать с красной строки.

public class var3_ex9 {
    public static void main(String[] args) {
        String text = "Напечатать слова русского текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.";

        // Разбиваем текст на слова и сортируем их по первой букве в алфавитном порядке
        List<String> words = Arrays.asList(text.split("\\s+"));
        words.sort(Comparator.comparingInt(s -> s.charAt(0)));

        // Печатаем слова, начинающиеся с новой буквы, с красной строки
        char currentLetter = 0;
        for (String word : words) {
            char firstLetter = word.charAt(0);
            if (firstLetter != currentLetter) {
                System.out.println();
                System.out.print(word + " ");
                currentLetter = firstLetter;
            } else {
                System.out.print(word + " ");
            }
        }
    }
}
