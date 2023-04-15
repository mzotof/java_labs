import java.util.InputMismatchException;
import java.util.Scanner;
//Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков ввода/вывода.
// При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать
// исключительные ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой
// записи (объекта) в файле, недопустимом значении поля и т.д.
class QuadraticEquation {
    public final double a, b, c;
    public QuadraticEquation(double a, double b, double c) {
        if (a == 0)
            throw new IllegalArgumentException("Параметр а не может быть равен 0");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public QuadraticEquation(double a, double b) {
        if (a == 0)
            throw new IllegalArgumentException("Параметр а не может быть равен 0");
        this.a = a;
        this.b = b;
        this.c = 0;
    }
    public QuadraticEquation(double a) {
        if (a == 0)
            throw new IllegalArgumentException("Параметр а не может быть равен 0");
        this.a = a;
        this.b = 0;
        this.c = 0;
    }
    public String toString() {
        return "(" + Double.toString(this.a) + ")x^2 + (" + Double.toString(this.b) + ")x + (" +
                Double.toString(this.c) + ")";
    }
    private double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    public double[] getRoots() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        }
    }

    public double getExtrema() {
        return -b / (2 * a);
    }

    public double[] getIncreasingInterval() {
        double extrema = getExtrema();
        if (a > 0) {
            return new double[]{extrema, Double.POSITIVE_INFINITY};
        } else {
            return new double[]{Double.NEGATIVE_INFINITY, extrema};
        }
    }

    public double[] getDecreasingInterval() {
        double extrema = getExtrema();
        if (a > 0) {
            return new double[]{Double.NEGATIVE_INFINITY, extrema};
        } else {
            return new double[]{extrema, Double.POSITIVE_INFINITY};
        }
    }

    public double getLargestRoot() {
        double[] roots = getRoots();
        if (roots.length == 0)
            return Double.NaN;
        else if (roots.length == 1)
            return roots[0];
        else
            return Math.max(roots[0], roots[1]);
    }

    // Method to get the smallest root of the quadratic equation
    public double getSmallestRoot() {
        double[] roots = getRoots();
        if (roots.length == 0)
            return Double.NaN;
        else if (roots.length == 1)
            return roots[0];
        else
            return Math.min(roots[0], roots[1]);
    }
}

public class var1_ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество уравнений: ");
        int n;
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число типа int");
            return;
        }

        QuadraticEquation[] equations;
        try {
            equations = new QuadraticEquation[n];
        } catch (NegativeArraySizeException e) {
            System.out.println("Количество уравнений должно быть положительным");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Введите параметры a, b, c для " + (i + 1) + "-ого уравнения: ");
            double a, b, c;
            try {
                a = in.nextDouble();
                b = in.nextDouble();
                c = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести число типа double");
                return;
            } catch (OutOfMemoryError e) {
                System.out.println("Нехватка памяти");
                return;
            }

            try {
                equations[i] = new QuadraticEquation(a, b, c);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (QuadraticEquation equation : equations) {
            System.out.println("Уравнение " + equation + ":");
            System.out.println("Наименьший корень: " + equation.getSmallestRoot());
            System.out.println("Наибольший корень: " + equation.getLargestRoot());
            System.out.println();
        }
    }
}
