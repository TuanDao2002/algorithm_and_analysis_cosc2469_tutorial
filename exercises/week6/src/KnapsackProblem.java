import java.util.Arrays;

public class KnapsackProblem {
    static int totalSum(int[] selectedStates) {
        int sum = 0;
        for (int value : selectedStates) {
            sum += value;
        }

        return sum;
    }

    static int[] Knapsack(int capacity, int[] wt, int[] val, int[] selectedStates, int stateIdx, int currentIdx) {
        if (currentIdx < 0 || capacity < 0) {
            return selectedStates;
        }

        if (wt[currentIdx] > capacity) return Knapsack(capacity, wt, val, selectedStates, stateIdx, currentIdx - 1);

        int[] newSelectedStates = new int[selectedStates.length];
        System.arraycopy(selectedStates, 0, newSelectedStates, 0, selectedStates.length);
        newSelectedStates[stateIdx] = val[currentIdx];

        int[] included = Knapsack(capacity - wt[currentIdx], wt, val, newSelectedStates, stateIdx + 1, currentIdx - 1);
        int[] notIncluded = Knapsack(capacity, wt, val, selectedStates, stateIdx, currentIdx - 1);

        if (totalSum(included) + val[currentIdx] > totalSum(notIncluded)) return included;
        return notIncluded;
    }

    public static void main(String[] args) {
        int C = 50;
        int[] weight = new int[]{10, 20, 30};
        int[] value = new int[]{60, 120, 100};

        System.out.println(Arrays.toString(Knapsack(C, weight, value, new int[value.length], 0, value.length - 1)));
    }
}
