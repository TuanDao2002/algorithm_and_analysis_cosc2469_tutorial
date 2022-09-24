import java.util.stream.IntStream;

public class Problem2 {
    static int findMissingNumber(int[] arr) {
        int len = arr.length;
        int total = 1;
        for (int i = 2; i <= len + 1; i++) {
            total += i;
            total -= arr[i - 2];
        }

        return total;
    }
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i - 1] = i;
        }

        int missingNumber = 2;
        int[] finalArr = arr;
        arr = IntStream.range(0, arr.length)
                .filter(i -> i != missingNumber - 1)
                .map(i -> finalArr[i])
                .toArray();
        System.out.printf("The missing number is %d", findMissingNumber(arr));
    }
}
