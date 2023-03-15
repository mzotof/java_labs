public class QuadraticEquation {
    public final double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = 0;
    }

    public QuadraticEquation(double a) {
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
