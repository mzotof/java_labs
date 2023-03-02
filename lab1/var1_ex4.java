import java.util.Scanner;

public class var1_ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pass_sample = "correct_password";
        System.out.print("Enter password: ");
        String password = in.next();
        if (password.equals(pass_sample)) {
            System.out.print("Password is correct");
        }
        else {
            System.out.print("Password is incorrect");
        }
    }
}
