import java.util.Objects;

public class Problem4 {
    static int compareTime(String time1, String time2) {
        String[] partsOfTime1 = time1.split(":");
        String[] partsOfTime2 = time2.split(":");

        if (!Objects.equals(partsOfTime1[0], partsOfTime2[0])) {
            return Integer.parseInt(partsOfTime1[0]) - Integer.parseInt(partsOfTime2[0]);
        }

        return Integer.parseInt(partsOfTime1[1]) - Integer.parseInt(partsOfTime2[1]);
    }

    static int findMinNumOfGates(String[] arrival, String[] departure) {
        int minNumOfGates = 1;
        int numOfReaching = arrival.length;

        String latestDepartureTime = departure[0];
        for (int i = 1; i < numOfReaching; i++) {
            if (compareTime(arrival[i], latestDepartureTime) < 0) {
                minNumOfGates += 1;
                if (compareTime(departure[i], latestDepartureTime) < 0) {
                    latestDepartureTime = departure[i];
                }
            } else {
                latestDepartureTime = departure[i];
            }
        }

        return  minNumOfGates;
    }

    public static void main(String[] args) {
        String[] arrival = {"1:00", "1:40", "1:50", "2:00", "2:25", "4:00"};
        String[] departure = {"1:10", "1:55", "2:20", "2:30", "3:15", "6:00"};

        System.out.println(findMinNumOfGates(arrival, departure));
    }
}
