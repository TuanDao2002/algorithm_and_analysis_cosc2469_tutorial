public class Problem3 {
    static boolean containsConsecutive(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        return max - min + 1 == len;
    }
    public static void main(String[] args) {
        int[] arr = {8, 6, 5, 7, 8};
        System.out.println(containsConsecutive(arr));
    }
}
