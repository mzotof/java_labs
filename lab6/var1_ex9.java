import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class var1_ex9 {
    public static void main(String[] args) {
        File inputFile = new File("var1_ex9.txt");
        Set<String> uniqueWords = new HashSet<>();
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    uniqueWords.add(word.toLowerCase());
                }
            }
            bufferedReader.close();

            System.out.println("Unique words:");
            for (String word : uniqueWords) {
                System.out.println(word);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
