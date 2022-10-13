import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static boolean hasNoPrerequisite(int[] arr) {
        for (int val : arr) {
            if (val != 0) return false;
        }

        return true;
    }

    public static void topologicalOrder(int[][] arr, ArrayList<Integer> learningOrder) {
        int numOfCourse = arr.length;
        if (learningOrder.size() == numOfCourse) {
            for (Integer order : learningOrder) {
                System.out.print(order +  " ");
            }

            System.out.println();
            return;
        }

        for (int j = 0; j < numOfCourse; j++) {
            if (arr[j][j] != 0) {
                System.out.printf("Cell [%d][%d] is invalid", j, j);
                return;
            }

            if (learningOrder.contains(j) || (!hasNoPrerequisite(arr[j]))) continue;

            for (int i = 0; i < numOfCourse; i++) {
                if (arr[i][j] != 0) {
                    arr[i][j] = 0;
                }
            }

            for (int[] course : arr) {
                System.out.println(Arrays.toString(course));
            }
            learningOrder.add(j);
            System.out.println(learningOrder);
            System.out.println();
            break;
        }

        topologicalOrder(arr, learningOrder);
    }
    public static void main(String[] args) {
//        int[][] courses = new int[][] {
//                {0, 0, 0, 0},
//                {1, 0, 1, 0},
//                {0, 0, 0, 1},
//                {1, 0, 0, 0}
//        };

        int[][] courses = new int[][] {
                {0, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        topologicalOrder(courses, new ArrayList<>());
    }
}
