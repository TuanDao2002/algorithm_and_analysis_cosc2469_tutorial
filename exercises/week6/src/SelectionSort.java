import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        int len = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len - 1; i++) { // does not need to sort the last element
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

    static void bubbleSort(int[] arr) {
        int len = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

                System.out.println(Arrays.toString(arr));
                if (!swapped) return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("selection sort");
        selectionSort(new int[]{5, 1, 9, 6, 2});
        System.out.println("selection sort");
        selectionSort(new int[]{1, 2, 5, 6, 9});
        System.out.println("bubble sort");
        bubbleSort(new int[]{1, 2, 5, 6, 9});
    }
}
