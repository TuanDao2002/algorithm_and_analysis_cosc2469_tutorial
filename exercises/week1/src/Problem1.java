public class Problem1 {
    /*
        A[0, N-1]
        Largest = A[0]
        for idx = 1 to N - 1
            if (A[idx] > Largest)
                Largest = A[idx]

         return Largest
     */
    static int findLargest(int[] arr) {
        if (arr.length < 1) return -1;
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        return max;
    }

    /*
        A[0, N-1]
        if (A[0] > A[1])
            Largest = A[0]
            secondLargest = A[1]
        else
            Largest = A[1]
            secondLargest = A[0]

        for idx = 2 to N - 1
            if (A[idx] > Largest)
                secondLargest = Largest
                Largest = A[idx]
            else if A[idx] > secondLargest
                secondLargest = A[idx]

         return secondLargest
     */
    static int findSecondLargest(int[] arr) {
        if (arr.length < 1) return -1;
        int max = arr[0];
        int max2 = arr[0];

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
        int[] arr = new int[]{11};
        System.out.println(findLargest(arr));
        System.out.println(findSecondLargest(arr));
    }
}

