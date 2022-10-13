import java.util.Arrays;

public class Problem1 {
    public static void insertionSort(int[] arr) {
        int arrLen = arr.length;
        for (int i = 1; i < arrLen; i++) {
            int mark = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > mark) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = mark;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,9,6,2};
        insertionSort(arr);
    }
}
