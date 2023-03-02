import java.util.*;

public class var2_ex9_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int[] a = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    isSorted = false;
                    buf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buf;
                }
            }
        }
        System.out.print("Array in ascending order: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\nArray in descending order: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int item : a) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        System.out.print("\nArray in descending order of frequency of occurrence: ");
        while (!map.isEmpty()) {
            int max_val_key = map.keySet().iterator().next();
            for (int key : map.keySet()) {
                if (map.get(key) > map.get(max_val_key)) {
                    max_val_key = key;
                }
            }
            for (int i = 0; i < map.get(max_val_key); i++) {
                System.out.print(max_val_key + " ");
            }
            map.remove(max_val_key);
        }
    }
}
