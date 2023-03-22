import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class var3_ex9 {
    public static void main(String[] args) {
        String inputFilePath = "var3_ex9.txt";

        try {
            Scanner inputFile = new Scanner(new File(inputFilePath));

            int matrixSize = 0;
            int[][] matrixData = null;
            int i = 0;

            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] elements = line.split(" ");
                if (matrixSize == 0) {
                    matrixSize = elements.length;
                    matrixData = new int[matrixSize][matrixSize];
                }
                for (int j = 0; j < matrixSize; j++) {
                    matrixData[i][j] = Integer.parseInt(elements[j]);
                }
                i++;
            }
            inputFile.close();
            System.out.println("Original Matrix:");
            printMatrix(matrixData);
            int[][] transposedMatrixData = transposeMatrix(matrixData);
            System.out.println("Transposed Matrix:");
            printMatrix(transposedMatrixData);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
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
