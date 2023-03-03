import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import static java.lang.Math.abs;

public class var1_ex9_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = in.nextInt();
        System.out.println("\nFor intervals (-10k, 0]; (0, 5]; (5, 10]; (10, 10k] :");
        switch (k) {
            case 0 -> System.out.println(k + " belongs to interval (-10k, 0]");
            case 1, 2, 3, 4, 5 -> System.out.println(k + " belongs to interval (0, 5]");
            case 6, 7, 8, 9, 10 -> System.out.println(k + " belongs to interval (5, 10]");
            default -> {
                switch ((int) k / abs(k)) {
                    case -1 -> System.out.println(k + " does not belong to any interval");
                    default -> System.out.println(k + " belongs to interval (10, 10k]");
                }
            }
        }
        System.out.println("\nFor intervals (-10k, 5]; [0, 10]; [5, 15]; [10, 10k] :");
        switch (k) {
            case 0 -> System.out.println(k + " belongs to interval [0, 10]");
            case 1, 2, 3, 4 -> {
                System.out.println(k + " belongs to interval (-10k, 5]");
                System.out.println(k + " belongs to interval [0, 10]");
            }
            case 5 -> {
                System.out.println(k + " belongs to interval (-10k, 5]");
                System.out.println(k + " belongs to interval [0, 10]");
                System.out.println(k + " belongs to interval [5, 15]");
            }
            case 6, 7, 8, 9 -> {
                System.out.println(k + " belongs to interval [0, 10]");
                System.out.println(k + " belongs to interval [5, 15]");
            }
            case 10 -> {
                System.out.println(k + " belongs to interval [0, 10]");
                System.out.println(k + " belongs to interval [5, 15]");
                System.out.println(k + " belongs to interval [10, 10k]");
            }
            case 11, 12, 13, 14, 15 -> {
                System.out.println(k + " belongs to interval [5, 15]");
                System.out.println(k + " belongs to interval [10, 10k]");
            }
            default -> {
                switch ((int) k / abs(k)) {
                    case -1 -> System.out.println(k + " does not belong to any interval");
                    default -> System.out.println(k + " belongs to interval [10, 10k]");
                }
            }
        }
        System.out.println("\nDeveloper: Zotov M.A.");
        System.out.println("Exercise received: 2023-02-17 17:25:00");
        System.out.println("Exercise handed over: " + LocalDate.now() + " " + LocalTime.now());
    }
}
