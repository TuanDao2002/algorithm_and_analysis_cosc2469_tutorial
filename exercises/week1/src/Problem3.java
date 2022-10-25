import java.util.HashMap;

public class Problem3 {
    static boolean isPermutation(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        if (len1 != len2) return false;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            freq.put(arr1[i], freq.get(arr1[i]) == null ? 1 : freq.get(arr1[i]) + 1);
            freq.put(arr2[i], freq.get(arr2[i]) == null ? 1 : freq.get(arr2[i]) + 1);
        }

        for (int key : freq.keySet()) {
            if (freq.get(key) <= 1) return false;
        }

        return true;
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
