//На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость.
// Определить, сколько произойдет обгонов.
public class var2_ex10 {
    public static int countOvertakings(int[] positions, int[] speeds) {
        int numCars = positions.length;
        int numOvertakings = 0;

        for (int i = 0; i < numCars; i++) {
            for (int j = i + 1; j < numCars; j++) {
                if (positions[i] < positions[j] && speeds[i] > speeds[j]) {
                    numOvertakings++;
                }
            }
        }

        return numOvertakings;
    }

    public static void main(String[] args) {
        int[] positions = {10, 20, 30, 40};
        int[] speeds = {3, 5, 2, 4};

        int numOvertakings = countOvertakings(positions, speeds);

        System.out.println("Number of overtakings: " + numOvertakings);
    }
}
