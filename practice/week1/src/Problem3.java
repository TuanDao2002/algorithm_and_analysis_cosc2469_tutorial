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

        boolean[] visited = new boolean[len];
        if (max - min + 1 == len) {
            for (int val : arr) {
                if (visited[val - min]) {
                    return false;
                }

                visited[val - min] = true;
            }

            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println(containsConsecutive(arr));
    }
}
