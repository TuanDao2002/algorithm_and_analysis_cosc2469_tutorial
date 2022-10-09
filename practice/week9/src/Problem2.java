import java.util.Arrays;

public class Problem2 {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // can only use Lomunto partition scheme
    static int partition(int[] arr, int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    // use random pivot reduce number of steps
    static int randomPartition(int[] arr, int l, int r) {
        int n = r - l + 1;
        int pivot = (int)(Math.random() * (n - 1));
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

//    This approach is similar to the quick sort algorithm where we use the partition on the input array recursively.
//    But unlike quicksort, which processes both sides of the array recursively,
//    this algorithm works on only one side of the partition.
//    We recur for either the left or right side according to the position of pivot.
//    If we randomly select the pivot, the expected time complexity would be linear, O(n).
    static int findKthSmallestElement(int[] arr, int left, int right, int k) {
        if (left > right || k > right - left + 1) {
            System.out.println(left);
            System.out.println(right);
            return -1;
        }

        System.out.println("left:" + left);
        System.out.println("right:" + right);
        int pos = randomPartition(arr, left, right);
        System.out.println("pos: " + pos);
        System.out.println("Array: " + Arrays.toString(arr));
        if (k - 1 == pos - left) {
            return arr[pos];
        }

        if (k - 1 < pos - left) {
            System.out.println("lower");
            return findKthSmallestElement(arr, left, pos - 1, k);
        }

        System.out.println("upper");
        return findKthSmallestElement(arr, pos + 1, right, (k - 1) - (pos - left));
    }

    public static void main(String[] args) {
        int ARR_SIZE = 10;
        int[] arr = new int[ARR_SIZE];
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = (int) (Math.random() * ARR_SIZE);
        }

        arr = new int[]{1,2,3,4,5,6,7,8};

        System.out.println("Original: ");
        System.out.println(Arrays.toString(arr));

        System.out.println("Result: ");
        System.out.println(findKthSmallestElement(arr, 0, arr.length - 1, 7));

        System.out.println("After sort: ");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
