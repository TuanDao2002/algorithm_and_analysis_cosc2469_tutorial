public class Problem1 {
    static int secondLargest(int[] arr) {
        if (arr.length < 1) {
            return -1;
        } else if (arr.length == 1) {
            return arr[0];
        } else {
            int max = arr[0];
            int max2 = arr[1];

            if (max < max2) {
                int temp = max;
                max = max2;
                max2 = temp;
            }

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] > max) {
                    max2 = max;
                    max = arr[i];
                } else if (arr[i] > max2) {
                    max2 = arr[i];
                }
            }

            return max2;
        }
    }

    public static void main(String[] args) {
        int[] marks = { 12, 112, 22 };
        System.out.println(secondLargest(marks));
    }
}
