public class Problem2 {
    // approach without using HashMap
    static void printAllUnique(int[] arr) {
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {423, 232, 423, 11, 6, 423};
        printAllUnique(arr);
    }
}
