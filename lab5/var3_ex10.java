import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class var3_ex10 {
    public static void main(String[] args) {
        String inputFilePath = "var3_ex10.txt";

        try {
            Scanner inputFile = new Scanner(new File(inputFilePath));

            int matrixSize = 0;
            int[][] matrixData = null;
            int i = 0;

            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                if (matrixSize == 0) {
                    matrixSize = line.length();
                    matrixData = new int[matrixSize][matrixSize];
                }
                for (int j = 0; j < matrixSize; j++) {
                    matrixData[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
                i++;
            }
            inputFile.close();
            System.out.println("Original Matrix:");
            printMatrix(matrixData);
            int[][] transposedMatrixData = rotateMatrix(matrixData);
            System.out.println("Transposed Matrix:");
            printMatrix(transposedMatrixData);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] rotatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedMatrix[j][size - 1 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int[] rows : matrix) {
            for (int elem : rows) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
