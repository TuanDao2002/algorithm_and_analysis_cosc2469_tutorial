import java.util.Arrays;

public class PairChecking {
    static boolean checkPair(int[] A, int S) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        while (l != r) {
            if (A[l] + A[r] > S) {
                r--;
            } else if (A[l] + A[r] < S) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkPair(new int[]{0, 5, 8, 2, 1, 3}, 10));
    }
}
