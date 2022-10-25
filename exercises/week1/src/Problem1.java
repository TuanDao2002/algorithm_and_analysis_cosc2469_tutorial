public class Problem1 {
    static int findLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        return max;
    }

    static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                max2 = max;
                max = val;
            } else if (val > max2 && val < max) {
                max2 = val;
            }
        }

        return max2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 11, 9, 3, 2, 10};
        System.out.println(findLargest(arr));
        System.out.println(findSecondLargest(arr));
    }
}

