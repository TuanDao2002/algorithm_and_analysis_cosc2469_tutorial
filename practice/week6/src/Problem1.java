import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Problem1 {
    static int MAX = 100;

    static void distributionSorting(int[] arr) {
        int len = arr.length;
        int[] sorted = new int[len];
        int[] frequencies = new int[MAX + 1];

        for (int i = 0; i < MAX; i++) {
            ++frequencies[arr[i]];
        }

        for (int i = 1; i <= MAX; i++) {
            frequencies[i] += frequencies[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            sorted[frequencies[arr[i]] - 1] = arr[i];
            --frequencies[arr[i]];
        }

        System.arraycopy(sorted, 0, arr, 0, len);
    }

    public static void main(String[] args) {
        int[] arr = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            arr[i] = (int) (Math.random() * (MAX - 1) + 1);
        }

        int[] test = new int[arr.length];
        System.arraycopy(arr, 0, test, 0, arr.length);
        System.out.println(Arrays.toString(arr));

        Instant start = Instant.now();
        Arrays.sort(test);
        Instant end = Instant.now();

        System.out.println(Arrays.toString(test));
        System.out.println("Elapsed Time of builtin sort: "+ Duration.between(start, end).toString());

        start = Instant.now();
        distributionSorting(arr);
        end = Instant.now();

        System.out.println(Arrays.toString(arr));
        System.out.println("Elapsed Time of distribution sort: "+ Duration.between(start, end).toString());
    }
}
