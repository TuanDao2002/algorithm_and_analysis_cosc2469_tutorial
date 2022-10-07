import java.util.ArrayList;

public class Problem3 {
    static void findAllSubsets(ArrayList<String> subset, String[] input, String substring, int index) {
       if (index == input.length) {
           System.out.println("Substring: " + substring);
           subset.add(substring);
           return;
       }

//       Not Including Value which is at Index
       findAllSubsets(subset, input, substring, index + 1);

//       Including Value which is at Index
       String newSubString = substring + input[index];
       System.out.println("new Substring: " + newSubString);
       findAllSubsets(subset, input, newSubString, index + 1);
    }

    public static void main(String[] args) {
//        Main List for storing all subsets
        ArrayList<String> subset = new ArrayList<>();
        String[] input = new String[]{"A", "B", "C"};
        findAllSubsets(subset, input, "", 0);

        for (String s : subset) {
            System.out.println(s);
        }
    }
}
