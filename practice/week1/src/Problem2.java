import java.util.Arrays;
import java.util.Random;

public class Problem2 {
    static int findIndex(int[] arr) {
        System.out.println(Arrays.toString(arr));
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i - 1] = i;
        }

        Random rgen = new Random();  // Random number generator

        for (int i = 0; i < arr.length; i++) {
            int randomPosition = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }

        System.out.println(findIndex(arr));
    }
}
