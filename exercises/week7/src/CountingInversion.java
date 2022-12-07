import java.util.Arrays;

public class CountingInversion {
    static int countWhenMerge(int[] subArr1, int[] subArr2, int[] arr) {
        int len1 = subArr1.length;
        int len2 = subArr2.length;
        int len = arr.length;

        int count = 0;
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
            // as the left array is already in ascending order,
            // we can add a number of conversion equals to number of remaining larger numbers in the left array
            count += len1 - i1;
        }

        if (i1 < len1) System.arraycopy(subArr1, i1, arr, index, len1 - i1);
        if (i2 < len2) System.arraycopy(subArr2, i2, arr, index , len2 - i2);

        System.out.println(Arrays.toString(arr));
        System.out.println(count);

        return count;
    }

    static int numOfInversion(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int[] subArr1 = Arrays.copyOfRange(arr, 0, n / 2);
            int[] subArr2 = Arrays.copyOfRange(arr, n / 2, n);

            int n1 = numOfInversion(subArr1);
            int n2 = numOfInversion(subArr2);

            int n3 = countWhenMerge(subArr1, subArr2, arr);
            return n1 + n2 + n3;
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(numOfInversion(new int[]{1, 20, 6, 4, 5}));
        System.out.println(numOfInversion(new int[]{8, 4, 2, 1}));
    }
}
