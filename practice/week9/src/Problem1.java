import java.util.Arrays;

public class Problem1 {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    static void merge(int[] subArr1, int[] subArr2, int[] arr) {
        int len1 = subArr1.length;
        int len2 = subArr2.length;
        int len = arr.length;

        int i1 = 0, i2 = 0;
        int index = 0;
        while (i1 < len1 && i2 < len2 && index < len) {
            if (subArr1[i1] < subArr2[i2]) {
                arr[index] = subArr1[i1];
                i1++;
                index++;
                continue;
            }

            arr[index] = subArr2[i2];
            i2++;
            index++;
        }

        if (i1 < len1) System.arraycopy(subArr1, i1, arr, index, len1 - i1);
        if (i2 < len2) System.arraycopy(subArr2, i2, arr, index , len2 - i2);

//        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int[] subArr1 = Arrays.copyOfRange(arr, 0, n / 2);
            int[] subArr2 = Arrays.copyOfRange(arr, n / 2, n);

//            System.out.println("Sub array 1: " + Arrays.toString(subArr1));
//            System.out.println("Sub array 2: " + Arrays.toString(subArr2));
            mergeSort(subArr1);
            mergeSort(subArr2);

            merge(subArr1, subArr2, arr);
        }
    }

    // Hoare Partition Scheme
    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left], i = left - 1, j = right + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);


            if (j <= i) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static void main(String[] args) {
        int ARR_SIZE = 100;
        int[] arr = new int[ARR_SIZE];
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = (int) (Math.random() * ARR_SIZE);
        }

        System.out.println("Original:");
        System.out.println(Arrays.toString(arr));
//        selectionSort(arr);
//        mergeSort(arr);
        quickSort(arr, 0, ARR_SIZE - 1);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(arr));
    }
}
