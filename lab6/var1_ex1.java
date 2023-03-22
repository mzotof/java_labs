import java.util.HashSet;
import java.util.Set;

class IntSet {
    private final Set<Integer> set;

    public IntSet() {
        set = new HashSet<>();
    }

    public IntSet(Set<Integer> set) {
        this.set = set;
    }

    public void add(int n) {
        set.add(n);
    }

    public IntSet intersection(IntSet otherSet) {
        Set<Integer> intersection = new HashSet<>(set);
        intersection.retainAll(otherSet.set);
        return new IntSet(intersection);
    }

    public IntSet union(IntSet otherSet) {
        Set<Integer> union = new HashSet<>(set);
        union.addAll(otherSet.set);
        return new IntSet(union);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer elem : set)
            sb.append(elem).append(" ");
        return sb.toString();
    }
}

public class var1_ex1 {
    public static void main(String[] args) {
        IntSet set1 = new IntSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntSet set2 = new IntSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntSet intersection = set1.intersection(set2);
        IntSet union = set1.union(set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Intersection: " + intersection);
        System.out.println("Union: " + union);
    }

}
