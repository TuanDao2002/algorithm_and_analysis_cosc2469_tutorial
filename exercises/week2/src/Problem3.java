import java.util.Objects;

public class Problem3 {
    static int compareTime(String time1, String time2) {
        String[] partsOfTime1 = time1.split(":");
        String[] partsOfTime2 = time2.split(":");

        if (!Objects.equals(partsOfTime1[0], partsOfTime2[0])) {
            return Integer.parseInt(partsOfTime1[0]) - Integer.parseInt(partsOfTime2[0]);
        }

        return Integer.parseInt(partsOfTime1[1]) - Integer.parseInt(partsOfTime2[1]);
    }

    static int findMinNumOfGates(String[] arrival, String[] departure) {
        int i, j;
        int gates, result;
        i = gates = result = 1;
        j = 0;
        while (i < arrival.length && j < departure.length) {
            if (compareTime(arrival[i], departure[j]) < 0) {
                gates++;
                i++;
            } else {
                gates--;
                j++;
            }
            if (gates > result) result = gates;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMinNumOfGates(new String[]{"1:00", "1:40", "1:50", "2:00", "2:15", "4:00"},
                new String[]{"1:10", "3:00", "2:20", "2:30", "3:15", "6:00"}));
    }
}