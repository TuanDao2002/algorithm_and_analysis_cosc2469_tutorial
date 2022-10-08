import java.util.ArrayList;

public class Problem3 {
    static void findAllSubsets(ArrayList<ArrayList<String>> subset, String[] input, ArrayList<String> substring, int index) {
       if (index == input.length) {
           subset.add(substring);
           return;
       }

//       Not Including Value which is at Index
       findAllSubsets(subset, input, new ArrayList<>(substring), index + 1);

//       Including Value which is at Index
       substring.add(input[index]);
       findAllSubsets(subset, input, new ArrayList<>(substring), index + 1);
    }

    public static void main(String[] args) {
//        Main List for storing all subsets
        ArrayList<ArrayList<String>> subset = new ArrayList<>();
        String[] input = new String[]{"A", "B", "C"};
        findAllSubsets(subset, input, new ArrayList<>(), 0);

        for (ArrayList<String> list : subset) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
