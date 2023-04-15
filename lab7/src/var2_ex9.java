import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//В стихотворении найти одинаковые буквы, которые встречаются во всех словах.

public class var2_ex9 {
    public static void main(String[] args) {
        String poem = "Морозъ иъ солнцеъ; деньъ чудесныйъ!\nЕщеъ тыъ дремлешьъ, другъ прелестныйъ –ъ\nПораъ, красавицаъ, проснисьъ:\nОткройъ сомкнутыъ негойъ взорыъ\nНавстречуъ севернойъ Аврорыъ,\nЗвездоюъ севераъ явисьъ!";

        Set<Character> commonChars = new HashSet<>(); // Множество общих букв
        boolean isFirstWord = true; // Флаг, указывающий, что это первое слово

        Scanner scanner = new Scanner(poem);
        while (scanner.hasNext()) {
            String word = scanner.next();
            Set<Character> currentChars = new HashSet<>(); // Множество букв в текущем слове

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (isFirstWord) {
                    commonChars.add(c); // Если это первое слово, добавляем все его буквы в множество общих букв
                } else {
                    if (commonChars.contains(c)) {
                        currentChars.add(c); // Если общие буквы содержат текущую букву, добавляем ее в множество текущих букв
                    }
                }
            }

            if (!isFirstWord) {
                commonChars.retainAll(currentChars); // Удаляем из множества общих букв те, которые не встречаются в текущем слове
            }

            isFirstWord = false; // Снимаем флаг первого слова
        }

        System.out.println("Общие буквы: " + commonChars); // Выводим результат
    }
}
