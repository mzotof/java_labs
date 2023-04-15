import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Рассортировать слова русского текста по возрастанию доли гласных букв
// (отношение количества гласных к общему количеству букв в слове)

public class var3_ex10 {
    public static void main(String[] args) {
        String text = "Рассортировать слова русского текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове)";

        // Разбиваем текст на слова
        List<String> words = Arrays.asList(text.split("\\s+"));

        // Сортируем слова по возрастанию доли гласных букв
        words.sort(new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                double vowelsFraction1 = countVowelsFraction(s1);
                double vowelsFraction2 = countVowelsFraction(s2);
                return Double.compare(vowelsFraction1, vowelsFraction2);
            }

            private double countVowelsFraction(String word) {
                int vowelCount = 0;
                int totalLetterCount = 0;
                for (char c : word.toCharArray()) {
                    if (isVowel(c)) {
                        vowelCount++;
                    }
                    totalLetterCount++;
                }
                return (double) vowelCount / totalLetterCount;
            }

            private boolean isVowel(char c) {
                return "аеёиоуыэюя".indexOf(Character.toLowerCase(c)) != -1;
            }
        });

        // Печатаем отсортированные слова
        for (String word : words) {
            System.out.println(word);
        }
    }
}
