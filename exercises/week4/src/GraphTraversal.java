import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    static void DFSUtil(int[][] adj, int startVertice, boolean[] visited) {
        int numOfVertices = adj.length;

        visited[startVertice] = true;
        System.out.print(startVertice + " ");

        for (int i = 0; i < numOfVertices; i++) {
            if (adj[startVertice][i] == 1 && !visited[i]) {
                DFSUtil(adj, i, visited);
            }
        }
    }

    static void DFSTraversalForGraph(int[][] adj, int startVertice) {
        System.out.println("DFS start at: " + startVertice);
        int numOfVertices = adj.length;
        boolean[] visited = new boolean[numOfVertices];
        DFSUtil(adj, startVertice, visited);
    }

    static void BFSTraversalForGraph(int[][] adj, int startVertice) {
        System.out.println("BFS start at: " + startVertice);
        int numOfVertices = adj.length;
        boolean[] visited = new boolean[numOfVertices];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertice);
        visited[startVertice] = true;

        while (!queue.isEmpty()) {
            int currentVertice = queue.peek();
            queue.poll();
            System.out.print(currentVertice + " ");

            for (int i = 0; i < numOfVertices; i++) {
                if (adj[currentVertice][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] adj = {
//                {0, 1, 0, 0, 0, 1},
//                {1, 0, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 0},
//                {0, 0, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 1},
//                {1, 0, 0, 0, 1, 0}
//        };

        int[][] adj = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
        };


        DFSTraversalForGraph(adj, 2);
        System.out.println();
        BFSTraversalForGraph(adj, 2);
    }
}
