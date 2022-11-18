import java.util.Arrays;

public class Leetcode2368 {
    private static boolean check(int[] arr, int toCheckValue) {
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }

        return test;
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        int count = 0;
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];

            if (node1 == 0 && !check(restricted, node2)) {
                System.out.println(Arrays.toString(edge));
                count++;
            } else if (node2 == 0 && !check(restricted, node1)) {
                System.out.println(Arrays.toString(edge));
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        System.out.println(reachableNodes(7, arr, new int[]{4,5}));
    }
}
