public class var1_ex10 {
    public static void main(String[] args) {
        boolean[][] tmp = new boolean[2][2];
        tmp[0][0] = true;
        tmp[0][1] = false;
        tmp[1][0] = false;
        tmp[1][1] = false;
        BoolMatrix m1 = new BoolMatrix(tmp);

        System.out.println("First matrix:");
        m1.print();

        tmp = new boolean[2][2];
        tmp[0][0] = true;
        tmp[0][1] = true;
        tmp[1][0] = true;
        tmp[1][1] = false;
        BoolMatrix m2 = new BoolMatrix(tmp);

        System.out.println("\nSecond matrix:");
        m2.print();

        BoolMatrix res_disjunction = m1.disjunction(m2);
        System.out.println("\nResult of disjunction:");
        res_disjunction.print();

        BoolMatrix res_multiplication = m1.multiplication(m2);
        System.out.println("\nResult of multiplication:");
        res_multiplication.print();

        BoolMatrix res_inversion = m1.inversion();
        System.out.println("\nResult of inversion first matrix:");
        res_inversion.print();

        System.out.println("\nAmount of ones in second matrix = " + Integer.toString(m2.countOnes()));

        m1.orderRows();
        System.out.println("\nResult of sorting first matrix:");
        m1.print();
    }
}
