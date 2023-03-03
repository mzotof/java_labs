import java.util.ArrayList;
import java.util.Scanner;

public class var2_ex9_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int[][] m = new int[n][n];
        int[] avg_row = new int[n];
        int max = -n;
        for(int i = 0; i < n; i++){
            avg_row[i] = 0;
            for(int j = 0; j < n; j++){
                m[i][j] = (int)(Math.random() * (2 * n + 1)) - n;
                avg_row[i] += m[i][j];
                if (m[i][j] > max) max = m[i][j];
            }
            avg_row[i] = avg_row[i] / n;
        }
        int[][] m_new1 = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m_new1[i][j] = m[i][j] - avg_row[i];
            }
        }
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(max == m[i][j]) {
                    if(!rows.contains(j))
                        rows.add(j);
                    if(!column.contains(i))
                        column.add(i);
                }
            }
        }
        int[][] m_new2 = new int[n - rows.size()][n - column.size()];
        int newArrI = 0;
        int newArrJ = 0;
        for (int i = 0; i < n; i++) {
            if(!rows.contains(i)) {
                newArrJ = 0;
                for (int j = 0; j < n; j++) {
                    if(!column.contains(j)) {
                        m_new2[newArrI][newArrJ] = m[j][i];
                        newArrJ++;
                    }
                }
                newArrI++;
            }
        }
        System.out.println("\nOriginal matrix:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("\nRow averages: ");
        for(int i = 0; i < n; i++){
            System.out.print(avg_row[i] + " ");
        }
        System.out.println("\nMatrix after subtraction:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(m_new1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nMax value: " + max);
        System.out.println("Matrix without rows and columns with max value:");
        for (int[] i : m_new2) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
