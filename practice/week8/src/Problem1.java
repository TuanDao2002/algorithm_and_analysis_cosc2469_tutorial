import java.util.Arrays;

public class Problem1 {
    static void selectionSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int temp;
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            int minIndex = i;
            for (int j = i; j < arrLen; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }

            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    static void bubbleSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int temp;
        boolean swapped;
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 1; i++) {
            swapped = false;
            for (int j = 0; j < arrLen - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                    System.out.println(Arrays.toString(arr));
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2, 8};

        int[] selectionArr = new int[arr.length], bubbleArr = new int[arr.length];
        System.arraycopy(arr, 0, selectionArr, 0, arr.length);
        System.arraycopy(arr, 0, bubbleArr, 0, arr.length);

        System.out.println("Selection sort:");
        selectionSort(selectionArr);
        System.out.println("Bubble sort:");
        bubbleSort(bubbleArr);
    }
}
