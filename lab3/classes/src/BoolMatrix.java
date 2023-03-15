import java.util.Arrays;
import java.util.Comparator;

public class BoolMatrix {
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
            throw new IllegalArgumentException("Matrices must have same dimensions");
        }
        BoolMatrix result = new BoolMatrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] || other.matrix[i][j];
            }
        }
        return result;
    }

    public BoolMatrix multiplication(BoolMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrices dimensions do not allow multiplication");
        }
        BoolMatrix result = new BoolMatrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] && other.matrix[i][j];
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
            for (int j = 0; j < this.cols; j++)
                System.out.print(Boolean.toString(this.matrix[i][j]) + "\t");
            System.out.println();
        }
    }
}