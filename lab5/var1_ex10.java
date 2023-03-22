import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class BoolMatrix {
    public final boolean[][] matrix;
    private final int rows, cols;

    public BoolMatrix(boolean[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public BoolMatrix(int rows, int cols) {
        this.matrix = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public BoolMatrix disjunction(BoolMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера");
        }
        BoolMatrix result = new BoolMatrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] | other.matrix[i][j];
            }
        }
        return result;
    }

    public BoolMatrix multiplication(BoolMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера");
        }
        BoolMatrix result = new BoolMatrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] & other.matrix[i][j];
            }
        }
        return result;
    }

    public BoolMatrix inversion() {
        BoolMatrix result = new BoolMatrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = !this.matrix[i][j];
            }
        }
        return result;
    }

    public int countOnes() {
        int count = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.matrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void orderRows() {
        Arrays.sort(matrix, new Comparator<boolean[]>() {
            @Override
            public int compare(boolean[] row1, boolean[] row2) {
                for (int i = 0; i < row1.length; i++) {
                    if (row1[i] != row2[i]) {
                        return row1[i] ? 1 : -1;
                    }
                }
                return 0;
            }
        });
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.matrix[i][j])
                    System.out.print("1\t");
                else
                    System.out.print("0\t");
            }
            System.out.println();
        }
    }
}

public class var1_ex10 {
    private static BoolMatrix inputBoolMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n;
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Необходимо ввести число типа int");
        }

        if (n == 0)
            throw new IllegalArgumentException("Размер матрицы должен быть положительным");

        boolean[][] matrix;
        try {
            matrix = new boolean[n][n];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException("Размер матрицы должен быть положительным");
        }

        System.out.println("Введите элементы матрицы (0/1):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int a;
                try {
                    a = in.nextInt();
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("Необходимо ввести 0 или 1");
                }
                if (a == 0)
                    matrix[i][j] = false;
                else if (a == 1)
                    matrix[i][j] = true;
                else
                    throw new IllegalArgumentException("Необходимо ввести 0 или 1");
            }

        return new BoolMatrix(matrix);
    }
    public static void main(String[] args) {
        BoolMatrix[] matrix = new BoolMatrix[2];
        for (int i = 0; i < 2; i++) {
            System.out.println((i + 1) + "-ая матрица:");
            try {
                matrix[i] = inputBoolMatrix();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        BoolMatrix res_disjunction;
        try {
            res_disjunction = matrix[0].disjunction(matrix[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("\nРезультат дизъюнкции:");
        res_disjunction.print();

        BoolMatrix res_multiplication;
        try {
            res_multiplication = matrix[0].multiplication(matrix[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("\nРезультат конъюнкции:");
        res_multiplication.print();

        BoolMatrix res_inversion = matrix[0].inversion();
        System.out.println("\nРезультат инверсии первой матрицы:");
        res_inversion.print();

        System.out.println("\nКоличество единиц во второй матрице = " + matrix[1].countOnes());

        matrix[0].orderRows();
        System.out.println("\nРезультат сортировки первой матрицы:");
        matrix[0].print();
    }
}
