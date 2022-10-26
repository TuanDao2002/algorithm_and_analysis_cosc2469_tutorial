public class Problem2 {
    /*
        A[0, N - 1]
        len = A.length
        arraySeries = N * (N + 1) / 2
        arraySum = 0
        for i = 0 to N - 1
            arraySum += A[i]
        return arraySeries - arraySum
     */
    static int findMissingNumber(int[] arr) {
        int sumOfArr = 0;

        for (int val : arr) {
            sumOfArr += val;
        }

        int N = arr.length;
        int sum = N * (N + 1) / 2;
        return sum - sumOfArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 4, 5};
        System.out.println(findMissingNumber(arr));
    }
}
