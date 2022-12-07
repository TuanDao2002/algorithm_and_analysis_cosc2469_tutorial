import java.util.Arrays;

public class SortingAlgorithms {
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

    public static void main(String[] args) {
        int ARR_SIZE = 1000000;
        int[] arr = new int[ARR_SIZE];
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = (int) (Math.random() * ARR_SIZE);
        }

//        System.out.println("Original:");
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(arr));
    }
}
