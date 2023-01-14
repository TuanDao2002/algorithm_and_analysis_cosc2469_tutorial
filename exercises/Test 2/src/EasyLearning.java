public class EasyLearning {
    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {0, 1, 5},
                {4, 0, 3},
                {2, 1, 0}
        };

        EasyLearning easyLearning = new EasyLearning(costs);
        System.out.println(easyLearning.directSequence());
        System.out.println(easyLearning.compare(new int[]{0, 2}, new int[]{0, 1, 2}));
        System.out.println(easyLearning.bestSequence());
    }

    int[][] costs;

    public EasyLearning(int[][] costs) {
        this.costs = costs;
    }

    // directSequence complexity O(1)
    public int directSequence() {
        int numOfCourse = costs.length;
        return costs[0][numOfCourse - 1];
    }

    // compare complexity O(1)
    // because the complexity only depends on number of courses N
    public int compare(int[] seq1, int[] seq2) {
        int numOfCourse1 = seq1.length;
        int numOfCourse2 = seq2.length;

        int cost1 = 0;
        int cost2 = 0;

        for (int i = 0; i < numOfCourse1 - 1; i++) {
            cost1 += costs[seq1[i]][seq1[i + 1]];
        }

        for (int i = 0; i < numOfCourse2 - 1; i++) {
            cost2 += costs[seq2[i]][seq2[i + 1]];
        }

        if (cost1 > cost2) {
            return 1;
        } else if (cost1 < cost2) {
            return -1;
        }

        return 0;
    }

    // bestSequence complexity O(N^2)
    public int bestSequence() {
        // adaptation of Prim's algorithm
        int n = costs.length;
        int length = 0;

        // use this array to mark nodes have been added already or not
        boolean[] added = new boolean[n];

        // distances between the tree being built with not-added nodes
        double[] distances = new double[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Double.MAX_VALUE;
        }

        // insert node zero (any node is OK) first, so set its distance to zero
        distances[0] = 0;

        System.out.print("The learning order: ");

        // stop when the number of added nodes = n
        int nodeCount = 0;
        while (nodeCount < n) {
            double shortest = Double.MAX_VALUE;
            int shortestNode = -1;

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

            System.out.print(shortestNode + " ");

            // add the shortest node to the tree
            added[shortestNode] = true;
            length += distances[shortestNode];
            nodeCount++;

            // update other distances to the tree, if any
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                if (distances[i] > costs[shortestNode][i]) {
                    // it is shorter to connect node i
                    // to the tree through the recently added node
                    distances[i] = costs[shortestNode][i];
                }
            }
        }

        System.out.println();
        return length;
    }
}