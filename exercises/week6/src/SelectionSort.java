import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        int len = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        selectionSort(new int[]{5, 1, 9, 6, 2});
    }
}
