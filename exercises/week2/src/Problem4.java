import java.util.Arrays;

public class Problem4 {
    static int[] sumCloseToZero(int[] arr) {
        int[] result = new int[2];
        int len = arr.length;
        int l = 0, r = len - 1;
        int minDiffToZero = Integer.MAX_VALUE;

        // sort the array first if it is not sorted
        Arrays.sort(arr);

        while(l < r) {
            if (Math.abs(arr[l] + arr[r]) < minDiffToZero) {
                result[0] = arr[l];
                result[1] = arr[r];
                minDiffToZero = Math.abs(arr[l] + arr[r]);
            }

            // if the sum is positive, move the right pivot to the left
            if (arr[l] + arr[r] > 0) {
                r--;
            } else {
                // if the sum is negative, move the left pivot to the right
                l++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr =  {-9, -2, 8, 9, 10, -7};
        System.out.println(Arrays.toString(sumCloseToZero(arr)));
    }
}
