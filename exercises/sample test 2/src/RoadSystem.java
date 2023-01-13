import java.util.Arrays;

public class RoadSystem {
    public static void main(String[] args) {
        Lab l1 = new Lab("Advanced AI", 0.0, 0.0);
        Lab l2 = new Lab("Cyber Security", 10, 0);
        Lab l3 = new Lab("IoT", 0, 10);
        RoadSystem rs = new RoadSystem();
        rs.addLab(l1);
        rs.addLab(l2);
        rs.addLab(l3);
        System.out.println(rs.simpleLength());  // return 24.142
        System.out.println(rs.optimalLength());
    }

    int maxNumOfLabs = 100;
    Lab[] labs = new Lab[maxNumOfLabs];
    int currentIdx = 0;

    // addLab complexity = O(1)
    public void addLab(Lab l) {
        labs[currentIdx++] = l;
    }

    // simpleLength complexity = O(N)
    public double simpleLength() {
        double length = 0;
        for (int i = 1; i < currentIdx; i++) {
            length += calDistance(labs[i], labs[i - 1]);
        }

        return length;
    }

    // optimalLength complexity = O(N^2)
    public int optimalLength() {
        int n = currentIdx;
        int length = 0;

        // use this array to mark nodes have been added already
        boolean[] added = new boolean[n];

        // distance between the tree being built and not-yet-added nodes
        double[] distances = new double[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        // insert node zero (any node is OK) first, so set its distance to zero
        distances[0] = 0;

        // stop when the number of added nodes = n
        int nodeCount = 0;
        while (nodeCount < n) {
            double shortest = Integer.MAX_VALUE;
            int shortestNode = -1;  // index of the node having the shortest distance to the tree

            // determine the shortest distance node to the tree
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                if (shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            if (shortest == Integer.MAX_VALUE) {
                // we cannot go further - the graph is not connected
                return Integer.MAX_VALUE;
            }

            // add the shortest node to the tree
            added[shortestNode] = true;
            length += distances[shortestNode];
            nodeCount++;

            // update other distances to the tree
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }

                double distance = calDistance(labs[shortestNode], labs[i]);
                if (distances[i] > distance) {  // whether connect through shortestNode is better?
                    distances[i] = distance;
                }
            }
        }
        return length;
    }

    private double calDistance(Lab l1, Lab l2) {
        return Math.sqrt((l1.x - l2.x) * (l1.x - l2.x) + (l1.y - l2.y) * (l1.y - l2.y));
    }

    public static class Lab {
        String name;
        double x;
        double y;

        public Lab(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
}
