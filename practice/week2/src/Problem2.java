import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    static int findMissingNumber(int[] arr, int l, int r) {
        System.out.println(Arrays.toString(arr));
        if (r == 0 || r <= l) return -1;

        int middleIndex = l + (r - l) / 2;
        int arrLen = arr.length;

        if (middleIndex < arrLen - 1) {
            if (arr[middleIndex + 1] - arr[middleIndex] != 1) {
                if (arr[middleIndex + 1] == arr[middleIndex]) {
                    return arr[middleIndex];
                } else {
                    return arr[middleIndex + 1] - 1;
                }
            }
        }

        if (middleIndex > 0) {
            if (arr[middleIndex] - arr[middleIndex - 1] != 1) {
                if (arr[middleIndex] == arr[middleIndex - 1]) {
                    return arr[middleIndex];
                } else {
                    return arr[middleIndex - 1] + 1;
                }
            }
        }

        int findUpper = findMissingNumber(arr, middleIndex + 1, r);
        if (findUpper != -1) return findUpper;

        return findMissingNumber(arr, l, middleIndex - 1);
    }
    public static void main(String[] args) {
        int N = 100;
        int[] arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        int missingNumber = 26;
        int[] finalArr = arr;
        arr = IntStream.range(0, arr.length)
                .filter(i -> i != missingNumber)
                .map(i -> finalArr[i])
                .toArray();

        System.out.printf("The missing number is %d", findMissingNumber(arr, 0, N));
    }
}
