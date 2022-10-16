import java.util.ArrayList;

public class Problem3 {
    static class Castle {
        private final int castleIndex;
        public int prevCastleIndex;
        public int distance = Integer.MAX_VALUE;

        public Castle(int castleIndex, int prevCastleIndex) {
            this.castleIndex = castleIndex;
            this.prevCastleIndex = prevCastleIndex;
        }
    }

    // Prim's algorithm
    static void displayShortestTotalLength(int[][] castles) {
        int castleLen = castles.length;
        if (castleLen == 0) {
            System.out.println("No castle");
            return;
        }

        ArrayList<Castle> castleArrayList = new ArrayList<>();
        ArrayList<Castle> roadArrayList = new ArrayList<>();


        for (int i = 0; i < castleLen; i++) {
            castleArrayList.add(new Castle(i, -1));
        }

        castleArrayList.get(0).distance = 0;
        castleArrayList.get(0).prevCastleIndex = 0;

        Castle currentCastle = castleArrayList.get(0);
        roadArrayList.add(currentCastle);
        castleArrayList.remove(currentCastle);

        while(castleArrayList.size() > 0) {
            int[] distancesToOtherCastle = castles[currentCastle.castleIndex];

            Castle nearestCastle = castleArrayList.get(0);
            int shortestDis = Integer.MAX_VALUE;

            for (Castle otherCastle : castleArrayList) {
                if (otherCastle.castleIndex == currentCastle.castleIndex) continue;

                if (otherCastle.distance == Integer.MAX_VALUE
                        || distancesToOtherCastle[otherCastle.castleIndex] < otherCastle.distance) {
                    otherCastle.distance = distancesToOtherCastle[otherCastle.castleIndex];
                    otherCastle.prevCastleIndex = currentCastle.castleIndex;
                }

            }

            for (Castle otherCastle : castleArrayList) {
                if (otherCastle.distance < shortestDis) {
                    nearestCastle = otherCastle;
                    shortestDis = otherCastle.distance;
                }
            }

            currentCastle = castleArrayList.get(castleArrayList.indexOf(nearestCastle));
            roadArrayList.add(currentCastle);
            castleArrayList.remove(currentCastle);
        }

        int totalLength = 0;
        for (Castle castle : roadArrayList) {
            if (castle.castleIndex == castle.prevCastleIndex) continue;
            System.out.println(castle.prevCastleIndex + " -> " + castle.castleIndex + ": distance " + castle.distance);
            totalLength += castle.distance;
        }

        System.out.println("The total length is: " + totalLength);
    }

    public static void main(String[] args) {
        int[][] castles = new int[][] {
                {0, 1, 2, 8},
                {1, 0, 3, 5},
                {2, 3, 0, 4},
                {8, 5, 4, 0}
        };

        displayShortestTotalLength(castles);
    }
}
