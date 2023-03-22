import java.util.Stack;

public class var2_ex9 {
    public static int[] findMaxRectangularSubmatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] result = new int[4]; // [rowStart, colStart, rowEnd, colEnd]
        int maxArea = 0;

        for (int i = 0; i < numRows; i++) {
            int[] heights = new int[numCols];
            for (int j = 0; j < numCols; j++) {
                heights[j] = matrix[i][j];
            }
            int[] subResult = findMaxRectangularSubarray(heights);
            int area = (subResult[2] - subResult[0] + 1) * (subResult[3] - subResult[1] + 1);
            if (area > maxArea) {
                maxArea = area;
                result[0] = i - (subResult[2] - subResult[0]);
                result[1] = subResult[1];
                result[2] = i;
                result[3] = subResult[3];
            }
        }

        return result;
    }

    public static int[] findMaxRectangularSubarray(int[] heights) {
        int numCols = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] left = new int[numCols];
        int[] right = new int[numCols];

        for (int i = 0; i < numCols; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.empty() ? 0 : stack.peek() + 1);
            stack.push(i);
        }

        stack.clear();

        for (int i = numCols - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.empty() ? numCols - 1 : stack.peek() - 1);
            stack.push(i);
        }

        int maxArea = 0;
        int[] result = new int[4]; // [rowStart, colStart, rowEnd, colEnd]

        for (int i = 0; i < numCols; i++) {
            int area = heights[i] * (right[i] - left[i] + 1);
            if (area > maxArea) {
                maxArea = area;
                result[0] = 0;
                result[1] = left[i];
                result[2] = heights[i] - 1;
                result[3] = right[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {1, 1, 1, 2, 2},
                {2, 2, 2, 2, 3},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}};

        int[] res = findMaxRectangularSubmatrix(matrix);

        for (int i = res[0]; i <= res[2]; i++) {
            for (int j = res[1]; j <= res[3]; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
}