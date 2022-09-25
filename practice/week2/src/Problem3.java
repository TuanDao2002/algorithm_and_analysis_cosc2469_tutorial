import java.util.ArrayList;
import java.util.HashMap;

public class Problem3 {
    static void printAllUnique(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int val : arr) {
            if (visited.containsKey(val)) {
                continue;
            }

            visited.put(val, true);
            result.add(val);
        }

        System.out.println(result);
    }
    public static void main(String[] args) {
        int[] arr = {423, 232, 423, 11, 6, 423};
        printAllUnique(arr);
    }
}
