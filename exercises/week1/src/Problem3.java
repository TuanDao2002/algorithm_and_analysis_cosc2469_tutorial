import java.util.*;

public class Problem3 {
    /*

     */
    static boolean isPermutation(Set<Integer> set1, Set<Integer> set2) {
        Iterator<Integer> value1 = set1.iterator();
        Iterator<Integer> value2 = set2.iterator();

        while (value1.hasNext()) {
            int element = value1.next();
            boolean found = false;
            value2 = set2.iterator();
            while (value2.hasNext()) {
                if (Objects.equals(element, value2.next())) {
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        while (value2.hasNext()) {
            int element = value2.next();
            boolean found = false;
            value1 = set1.iterator();
            while (value1.hasNext()) {
                if (Objects.equals(value1.next(), element)) {
                    found = true;
                    break;
                }
            }

            value2 = set2.iterator();
            if (!found) return false;
        }

        return true;
    }

    static boolean isPermutation2(Set<Integer> set1, Set<Integer> set2) {
        for (int element : set2) {
            int oldSize = set1.size();
            set1.remove(element);
            int newSize = set1.size();

            if (oldSize == newSize) return false;
        }

        return set1.size() <= 0;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

        if (isPermutation2(set1, set2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
