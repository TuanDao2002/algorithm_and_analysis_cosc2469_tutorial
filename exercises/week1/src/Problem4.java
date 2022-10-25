public class Problem4 {
    // generate an array of sum values accumulated at a specific index
    static int[] preCompute(int[] arr) {
        int arrLen = arr.length;
        int[] preComputeArr = new int[arrLen];

        preComputeArr[0] = arr[0];
        for (int i = 1; i < arrLen; i++) {
            preComputeArr[i] = preComputeArr[i - 1] + arr[i];
        }

        return preComputeArr;
    }

    // return sum of sub array by minus the accumulated value at right index with the one at left index
    static int sumOfSubArr(int[] preComputeArr, int L, int R) {
        if (L > R) return -1;
        if (L == 0) return preComputeArr[R];
        return preComputeArr[R] - preComputeArr[L - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 9, 8, 5, 4, 3};
        int[] preComputeArr = preCompute(arr); // O(n) to generate precompute array, but 0(1) to return value
        System.out.println(sumOfSubArr(preComputeArr, 0, 0));
        System.out.println(sumOfSubArr(preComputeArr, 6, 6));
        System.out.println(sumOfSubArr(preComputeArr, 0, 6));
        System.out.println(sumOfSubArr(preComputeArr, 3, 4));
    }
}
