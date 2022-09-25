import java.util.Arrays;

public class Problem5 {
    static int[] sumCloseToZero(int[] arr) {
        int[] result = new int[2];
        int len = arr.length;
        int l = 0, r = len - 1;
        int minDiffToZero = Integer.MAX_VALUE;

        while(l < r) {
            if (Math.abs(arr[l] + arr[r]) < minDiffToZero) {
                result[0] = arr[l];
                result[1] = arr[r];
                minDiffToZero = Math.abs(arr[l] + arr[r]);
            }

            if (arr[l] + arr[r] > 0) {
                r--;
            } else {
                l++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr =  {-9, -7, -2, 8, 9, 10};
        System.out.println(Arrays.toString(sumCloseToZero(arr)));
    }
}

