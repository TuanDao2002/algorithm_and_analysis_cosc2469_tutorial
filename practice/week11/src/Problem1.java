import java.util.Arrays;

// source: https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class Problem1 {
    // Binary search (note boundaries in the caller)
    // arr[] is ceilIndex in the caller
    static int CeilIndex(int[] arr, int l, int r, int key) {
        while (r > l + 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int[] arr, int size) {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = arr[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] < tailTable[0])
                // new smallest value
                tailTable[0] = arr[i];

            else if (arr[i] > tailTable[len - 1])
                // arr[i] wants to extend largest subsequence
                tailTable[len++] = arr[i];

            else {
                // arr[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable so the increasing order still remains in tailTable
                System.out.println("arr[i]: " + arr[i]);
                System.out.println("index: " + CeilIndex(tailTable, 0, len - 1, arr[i]));
                tailTable[CeilIndex(tailTable, 0, len, arr[i])] = arr[i];
            }

            System.out.println(Arrays.toString(tailTable));
        }

        System.out.println(Arrays.toString(tailTable));
        return len;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1, 5, 9, 6, 7, 2};
        int[] arr = new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6};
        System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(arr, arr.length));
    }
}
