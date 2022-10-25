public class Problem2 {
    // find the missing number by minus the  sum of the array
    static int findMissingNumber(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sumOfArr = 0;

        for (int val : arr) {
            if (val > max) {
                max = val;
            }

            if (val < min) {
                min = val;
            }

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
