import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//Из текста удалить все слова заданной длины, начинающиеся на согласную букву.

public class var1_ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = "Этот текст содержит слова разной длины и на разных буквах. Некоторые слова начинаются на согласные, а некоторые на гласные.";

        System.out.print("Введите длину слова: ");
        int length = in.nextInt(); // Заданная длина слова
        HashSet<Character> consonants = new HashSet<>(Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ')); // Согласные буквы

        String[] words = text.split("\\s+"); // Разбить текст на слова
        StringBuilder result = new StringBuilder(); // Результирующий текст

        for (String word : words) {
            if (word.length() == length && consonants.contains(Character.toLowerCase(word.charAt(0)))) {
                continue; // Пропустить слово
            }
            result.append(word).append(" "); // Добавить слово в результирующий текст
        }

        System.out.println(result.toString().trim()); // Вывести результат
    }
}
