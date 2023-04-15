import java.util.Scanner;

//Удалить из текста его часть, заключенную между двумя символами, которые вводятся
// (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).

public class var1_ex10 {
    public static void main(String[] args) {
        String text = "Этот текст (содержит) некоторые (части), которые нужно удалить.";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первый символ: ");
        char startChar = scanner.next().charAt(0);

        System.out.print("Введите второй символ: ");
        char endChar = scanner.next().charAt(0);

        StringBuilder result = new StringBuilder(); // Результирующий текст
        boolean isInside = false; // Флаг, указывающий, находимся ли мы внутри блока, который нужно удалить

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == startChar) {
                isInside = true; // Входим в блок, который нужно удалить
                continue;
            }

            if (c == endChar) {
                isInside = false; // Выходим из блока, который нужно удалить
                continue;
            }

            if (!isInside) {
                result.append(c); // Добавляем символ в результирующий текст, если мы не находимся внутри блока
            }
        }

        System.out.println(result.toString()); // Выводим результат
    }
}
