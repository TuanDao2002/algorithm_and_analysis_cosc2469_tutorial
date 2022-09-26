import java.util.Random;

public class Problem2 {
    static class CircularBuffer {
        private final static int length = 100000;
        private static int[] buffer = new int[length];
        private final static int start = 0;
        private static int end = 0;

        static void put(int timestamp) {
            buffer[end++] = timestamp;
            end = end % length;
        }

        static int getIndex(int timestamp) {
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == timestamp) return i;
            }
            return -1;
        }

        static int getOldestData() {
            return buffer[start];
        }

        static int getNewestData() {
            if (end > 0) {
                System.out.println("End:" + end);
                return buffer[end - 1];
            } else {
                return buffer[buffer.length - 1];
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            CircularBuffer.put(random.nextInt(200));
            if (i < 100) {
                System.out.printf("%d ", CircularBuffer.buffer[i]);
            }
        }

        System.out.println();
        System.out.println(CircularBuffer.getIndex(117));
        System.out.println(CircularBuffer.getOldestData());
        System.out.println(CircularBuffer.getNewestData());
    }
}
