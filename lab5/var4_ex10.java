import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m последних
// слов в каждой из последних n строк
public class var4_ex10 {

    public static void main(String[] args) {
        // 3
        // 2
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        System.out.print("Enter m: ");
        int m = in.nextInt();
        File inputFile = new File("var4_ex9.txt");
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] lastWords = new String[n];
            int lineCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineCount < n) {
                    lastWords[lineCount] = getWordsFromEnd(line, m);
                } else {
                    for (int i = 1; i < n; i++) {
                        lastWords[i-1] = lastWords[i];
                    }
                    lastWords[n-1] = getWordsFromEnd(line, m);
                }
                lineCount++;
            }
            bufferedReader.close();

            File outputDir = new File("var4_ex10_output_dir");
            outputDir.mkdir();

            File outputFile = new File(outputDir, "var4_ex10_output.txt");
            FileWriter writer = new FileWriter(outputFile);
            for (String words : lastWords) {
                writer.write(words + "\n");
            }
            writer.close();
            System.out.println("Output file written to: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static String getWordsFromEnd(String line, int m) {
        String[] words = line.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = Math.max(0, words.length - m); i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
