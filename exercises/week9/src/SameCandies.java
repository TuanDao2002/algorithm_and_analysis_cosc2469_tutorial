public class SameCandies {
    public static int equalCandiesBruteForce(int[] boxes) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < boxes.length; i++) {
            int tot = 0;
            for (int j = 0; j < boxes.length; j++) {
                tot += Math.abs(boxes[j] - boxes[i]);
            }
            if (tot < res) {
                res = tot;
            }
        }
        return res;
    }


    // Lomuto partition
    // Return a partition point p
    // Where all elements arr[left, p - 1] <= arr[p] <= all elements arr[p + 1, right]
    static int partitionL(int[] arr, int left, int right) {
        int p = arr[right];  // select the right-most element as pivot
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= p) {
                // swap
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                // increase i
                i++;
            }
        }
        // swap
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;

        return i;
    }

    // quick select - Lomuto partition
    static int quickSelectL(int[] arr, int left, int right, int k) {
        int p = partitionL(arr, left, right);
        if (k - 1 == p) { // ==
            return arr[p];
        }
        if (k - 1 > p) {  // k - 1
            return quickSelectL(arr, p + 1, right, k); //p + 1 //right
        }
        return quickSelectL(arr, left, p - 1, k); //left //p - 1
    }

    static int equalCandiesTransform(int[] arr) {
        int middlePos = arr.length / 2 + 1;
        int left = 0;
        int right = arr.length - 1;

        int median = quickSelectL(arr, left, right, middlePos);

        int minTotal = 0;
        for (int val : arr) {
            minTotal += Math.abs(val - median);
        }

        return minTotal;
    }

    public static void main(String[] args) {
        System.out.println(equalCandiesBruteForce(new int[]{5, 8, 3}));
        System.out.println(equalCandiesTransform(new int[]{5, 8, 3}));

        System.out.println(equalCandiesBruteForce(new int[]{9, 9, 9, 9, 10}));
        System.out.println(equalCandiesTransform(new int[]{9, 9, 9, 9, 10}));

        int SIZE = 1000;
        int[] test = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            test[i] = (int)(Math.random() * SIZE);
        }
        System.out.println(equalCandiesBruteForce(test.clone()));
        System.out.println(equalCandiesTransform(test));
    }
}
