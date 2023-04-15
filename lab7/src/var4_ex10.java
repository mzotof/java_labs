//Исключить из текста подстроку максимальной длины, начинающуюся и заканчивающуюся одним
// и тем же символом

public class var4_ex10 {
    public static void main(String[] args) {
        String text = "Это некоторый текст, содержащий подстроку максимальной длины, начинающуюся и заканчивающуюся символом 'о'.";

        String maxSubstring = "";
        int maxLength = 0;

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    String substring = text.substring(i, j + 1);
                    if (substring.length() > maxLength) {
                        maxSubstring = substring;
                        maxLength = substring.length();
                    }
                }
            }
        }

        String result = text.replace(maxSubstring, "");
        System.out.println(result);
    }
}
