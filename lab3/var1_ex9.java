public class var1_ex9 {
    public static void main(String[] args) {
        QuadraticEquation[] equations = new QuadraticEquation[]{
                new QuadraticEquation(1, 0, -1),
                new QuadraticEquation(-2),
                new QuadraticEquation(1, -3),
                new QuadraticEquation(3, -6, 3)
        };

        for (QuadraticEquation equation : equations) {
            System.out.println("Equation " + equation.toString() + ":");
            System.out.println("Smallest root of is: " + Double.toString(equation.getSmallestRoot()));
            System.out.println("Largest root of equation is: " + Double.toString(equation.getLargestRoot()));
            System.out.println();
        }
    }
}
