import java.util.Arrays;
import java.util.Random;

public class Problem1 {
    static int[] TwoDaysWithMaxInc(int[] arr) {
        if (arr.length == 2) return new int[]{0, 1};
        int[] pairOfDays = new int[]{0, 1};


        int maxInc = arr[1] - arr[0];
        int dayWithMinTemp = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[dayWithMinTemp]) {
                dayWithMinTemp = i;
            }

            if (arr[i] - arr[dayWithMinTemp] > maxInc) {
                maxInc = arr[i] - arr[dayWithMinTemp];
                pairOfDays[0] = dayWithMinTemp;
                pairOfDays[1] = i;
            }
        }

        System.out.println(arr[pairOfDays[0]]);
        System.out.println(arr[pairOfDays[1]]);

        return pairOfDays;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] days = new int[20];
        for (int i = 0; i < 20; i++) {
            if (i < 10 && i > 5) {
                days[i] = random.nextInt(100 - 50) + 50;
                continue;
            }
            days[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(days));
        System.out.println(Arrays.toString(TwoDaysWithMaxInc(days)));
    }
}
