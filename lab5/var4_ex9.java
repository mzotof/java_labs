import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
public class var4_ex9 {
    public static void main(String[] args) {
        File inputFile = new File("var4_ex9.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                if (words.length > 1) {
                    String temp = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = temp;
                }
                String modifiedLine = String.join(" ", words);
                output.append(modifiedLine).append("\n");
            }
            scanner.close();

            File outputDir = new File("var4_ex9_output_dir");
            outputDir.mkdir();

            File outputFile = new File(outputDir, "var4_ex9_output.txt");
            PrintWriter writer = new PrintWriter(outputFile);
            writer.print(output);
            writer.close();
            System.out.println("Output file written to: " + outputFile.getAbsolutePath());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile.getName());
        }
    }
}
