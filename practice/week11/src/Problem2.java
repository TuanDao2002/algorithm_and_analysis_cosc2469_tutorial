import java.util.ArrayList;
import java.util.Arrays;

// source: https://chidokun.github.io/2021/09/dijkstra-algorithm/
public class Problem2 {
    static class City {
        private final int cityIndex;
        public int prevCityIndex;
        public int distance = Integer.MAX_VALUE;

        public City(int cityIndex, int prevCityIndex) {
            this.cityIndex = cityIndex;
            this.prevCityIndex = prevCityIndex;
        }
    }

    static void displayShortestPath(int[][] distances) {
        int distancesLen = distances.length;
        if (distancesLen == 0) {
            System.out.println("No city");
            return;
        }

        ArrayList<City> cityArray = new ArrayList<>();
        ArrayList<City> pathArrayList = new ArrayList<>();

        cityArray.add(new City(0, 0));
        cityArray.get(0).distance = 0;

        for (int i = 1; i < distancesLen; i++) {
            cityArray.add(new City(i, -1));
        }


        City currentCity = cityArray.get(0);
        pathArrayList.add(currentCity);
        cityArray.remove(currentCity);

        while (cityArray.size() > 0) {
            for (City city : cityArray) {
                System.out.print(city.cityIndex + " ");
            }
            System.out.println();

            int[] distancesToOtherCity = distances[currentCity.cityIndex];
            System.out.println(Arrays.toString(distancesToOtherCity));

            City nearestCity = cityArray.get(0);
            int shortestDis = Integer.MAX_VALUE;

            for (City otherCity : cityArray) {
                if (otherCity.prevCityIndex == currentCity.cityIndex || otherCity.cityIndex == currentCity.cityIndex) continue;
                if (distancesToOtherCity[otherCity.cityIndex] == - 1) continue;

                if (otherCity.distance == Integer.MAX_VALUE) {
                    otherCity.distance = currentCity.distance + distancesToOtherCity[otherCity.cityIndex];
                    otherCity.prevCityIndex = currentCity.cityIndex;
                } else if (currentCity.distance + distancesToOtherCity[otherCity.cityIndex] < otherCity.distance) {
                    otherCity.distance = currentCity.distance + distancesToOtherCity[otherCity.cityIndex];
                    otherCity.prevCityIndex = currentCity.cityIndex;
                }

                System.out.println("index " + otherCity.cityIndex + " distance: " + otherCity.distance);
            }

            for (City otherCity : cityArray) {
                if (otherCity.distance < shortestDis) {
                    nearestCity = otherCity;
                    shortestDis = otherCity.distance;
                }
            }

            System.out.println("nearest: " + nearestCity.cityIndex + " distance: " + nearestCity.distance);

            currentCity = cityArray.get(cityArray.indexOf(nearestCity));
            pathArrayList.add(currentCity);
            cityArray.remove(currentCity);
        }

        for (City city : pathArrayList) {
            System.out.println("index " + city.cityIndex + " distance: " + city.distance + " prev: " + city.prevCityIndex);
        }

       display(pathArrayList);
    }

    static void display(ArrayList<City> pathArrayList) {
        City destination = pathArrayList.get(pathArrayList.size() - 1);
        int startingPoint = destination.cityIndex;
        pathArrayList.remove(destination);
        do {
            if (destination.cityIndex == startingPoint) {
                System.out.print(destination.cityIndex + " -> ");
                startingPoint = destination.prevCityIndex;
            }

            destination = pathArrayList.get(pathArrayList.size() - 1);

            if (destination.cityIndex == 0) {
                System.out.print(destination.cityIndex);
            }

            pathArrayList.remove(destination);
        } while (destination.prevCityIndex != destination.cityIndex);
    }

    public static void main(String[] args) {
        int[][] distances = new int[][] {
                {0, 3, 2, -1},
                {3, 0, -1, 5},
                {2, -1, 0, 9},
                {-1, 5, 9, 0}
        };

        displayShortestPath(distances);
    }
}
