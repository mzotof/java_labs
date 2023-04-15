//В тексте найти первую подстроку максимальной длины, не содержащую букв.

public class var2_ex10 {
    public static void main(String[] args) {
        String text = "Текст для поиска первой подстроки максимальной длины, не содержащей буквы.";

        String maxSubstring = "";
        String currentSubstring = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                // Нашли букву, обновляем текущую подстроку
                currentSubstring = "";
            } else {
                // Нашли не букву, добавляем к текущей подстроке
                currentSubstring += c;

                if (currentSubstring.length() > maxSubstring.length()) {
                    // Обновляем максимальную подстроку, если текущая длиннее
                    maxSubstring = currentSubstring;
                }
            }
        }

        System.out.println("Первая подстрока максимальной длины, не содержащая буквы: '" + maxSubstring + "'");
    }
}
