import java.util.ArrayList;

public class Problem4 {
    // image to display the process:
    // https://java2blog.com/wp-content/webpc-passthru.php?src=https://java2blog.com/wp-content/uploads/2018/08/recursionSubsetl.jpg&nocache=1&ezimgfmt=ng:webp/ngcb1
    static void findAllPermutations(ArrayList<String> subset, String[] input, String resultPermutation) {
        int inputLen = input.length;
        if (resultPermutation.length() == inputLen) {
            subset.add(resultPermutation);
            return;
        }

        StringBuilder resultPermutationBuilder = new StringBuilder(resultPermutation);
        for (int i = 0; i < inputLen; i++) {
            // continue if the permutation already contains the char
            if (resultPermutationBuilder.toString().contains(input[i])) continue;

            // add the new char to permutation
            resultPermutationBuilder.append(input[i]);
            resultPermutation = resultPermutationBuilder.toString();

            // find new permutations that contain the new added char
            findAllPermutations(subset, input, resultPermutation);

            // remove the element that has been added after recursion to generate new permutations
            resultPermutationBuilder.deleteCharAt(resultPermutation.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> subset = new ArrayList<>();
        String[] input = new String[]{"A", "B", "C"};
        findAllPermutations(subset, input, "");

        for (String s : subset) {
            System.out.println(s);
        }
    }
}
