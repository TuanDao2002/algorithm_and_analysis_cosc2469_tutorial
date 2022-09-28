import java.lang.instrument.ClassDefinition;
import java.util.LinkedList;
import java.util.Queue;

public class ATM {
    static int minWaitingTime(int[] A, int[] D) {
        int len = A.length;
        if (len == 1) return D[0];

        int minWaitingTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        minWaitingTime += D[0];
        queue.offer(A[0] + D[0]);

        for (int i = 1; i < A.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(A[i] + D[i]);
                minWaitingTime += D[i];
                continue;
            }

            int latestDepartureTime = queue.peek();
            int arrivalTime = A[i];
            if (arrivalTime < latestDepartureTime) {
                queue.offer(queue.peek() + D[i]);
            } else {
                while (!queue.isEmpty() && arrivalTime >= latestDepartureTime) {
                    latestDepartureTime = queue.peek();
                    queue.poll();
                }

                if (queue.isEmpty()) {
                    queue.offer(A[i] + D[i]);
                } else {
                    queue.offer(queue.peek() + D[i]);
                }

            }
            minWaitingTime += D[i];

            System.out.println(minWaitingTime);
        }

        return minWaitingTime;
    }

    static int maxWaitingTime(int[] A, int[] D) {
        int len = A.length;
        if (len == 1) return D[0];

        int maxWaitingTime = 0;
        int currTime = A[0];

        Queue<Integer> queue = new LinkedList<>();
        maxWaitingTime += D[0];
        queue.offer(A[0] + D[0]);

        for (int i = 1; i < A.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(A[i] + D[i]);
                maxWaitingTime += A[i] + D[i] - currTime;
                currTime = A[i] + D[i];
                continue;
            }

            int latestDepartureTime = queue.peek();
            int arrivalTime = A[i];
            if (arrivalTime < latestDepartureTime) {
                queue.offer(queue.peek() + D[i]);
            } else {
                while (!queue.isEmpty() && arrivalTime >= latestDepartureTime) {
                    latestDepartureTime = queue.peek();
                    queue.poll();
                }

                if (queue.isEmpty()) {
                    queue.offer(A[i] + D[i]);
                } else {
                    queue.offer(queue.peek() + D[i]);
                }
            }

            maxWaitingTime += A[i] + D[i] - currTime;
            currTime = A[i] + D[i];

            System.out.println(maxWaitingTime);
        }

        return maxWaitingTime;
    }

    static double avgWaitingTime(int[] A, int[] D) {
        int len = A.length;
        if (len == 1) return D[0];

        double totalWaitingTime = 0;
        for (int waitingTime : D) {
            totalWaitingTime += waitingTime;
        }

        return totalWaitingTime / len;
    }

    public static void main(String[] args) {
        int[] A = new int[]{20, 20, 27, 28};
        int[] D = new int[]{1, 1, 2, 3};

        System.out.println("Min time: " + minWaitingTime(A, D));
        System.out.println("Max time: " + maxWaitingTime(A, D));
        System.out.println("Avg time: " + avgWaitingTime(A, D));
    }
}
