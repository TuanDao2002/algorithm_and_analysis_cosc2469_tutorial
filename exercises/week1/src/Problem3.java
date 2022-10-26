import javax.sound.midi.Sequence;
import java.util.Iterator;
import java.util.Set;

public class Problem3 {
    /*

     */
    static boolean isPermutation(Set<Integer> set1, Set<Integer> set2) {
        int element;
        Iterator value1 = set1.iterator();
        while (value1.hasNext()) {
            boolean found = false;

        }
    }

    static boolean isPermutationWithMath(int[] arr1, int[] arr2) {
        int sum1 = 0, mul1 = 1, sum2 = 0, mul2 = 1;

        for (int v : arr1) {
            sum1 += v;
            mul1 *= v;
        }

        for (int v : arr2) {
            sum2 += v;
            mul2 *= v;
        }

        return sum1 == sum2 && mul1 == mul2;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 1, 5};
        if (isPermutationWithMath(arr1, arr2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
