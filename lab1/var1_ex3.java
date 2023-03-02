import java.util.Scanner;

public class var1_ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Hello Java!");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Hello Java!");
        }
    }
}
