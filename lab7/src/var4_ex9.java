//Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие)
// вхождения первой (последней) буквы этого слова

public class var4_ex9 {
    public static void main(String[] args) {
        String text = "Преобразовать каждое слово в тексте, удалив из него все последующие предыдущие вхождения первой последней буквы этого слова";
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            String transformedWord;
            if (word.length() > 2)
                transformedWord = firstChar
                        + word.substring(1, word.length() - 1)
                            .replaceAll(String.valueOf(firstChar), "")
                            .replaceAll(String.valueOf(lastChar), "")
                        + lastChar;
            else
                transformedWord = word;
            result.append(transformedWord).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
