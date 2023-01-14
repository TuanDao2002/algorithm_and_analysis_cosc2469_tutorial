public class DoraemonCake {
    public static void main(String[] args) {
        Topic topic1 = new Topic(8, 7);
        Topic topic2 = new Topic(10, 8);
        Topic topic3 = new Topic(5, 3);

        Topic[] topics = new Topic[]{topic1, topic2, topic3};
        double a = 10;

        DoraemonCake doraemonCake = new DoraemonCake(a, topics);
        System.out.println(doraemonCake.unlimitedCake());
        System.out.println(doraemonCake.weightByNumber(2));
        System.out.println(doraemonCake.largestWeight());
    }

    double A;
    Topic[] topics;
    double largestWeight = 0;

    public DoraemonCake(double a, Topic[] topics) {
        A = a;
        this.topics = topics;
    }

    // unlimitedCake complexity = O(N)
    public double unlimitedCake() {
        double largestWeight = 0;
        int size = topics.length;
        for (int i = 0; i < size; i++) {
            largestWeight += topics[i].W;
        }

        return largestWeight;
    }

    private int largestWeightTopic(boolean[] visited, Topic[] topics) {
        int size = topics.length;
        int maxIdx = 0;
        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            }

            if (topics[i].W > topics[maxIdx].W) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    // weightByNumber complexity = O(N)
    // the time to solve is O(N * X) or O(N)
    public double weightByNumber(int X) {
        double weight = 0;
        boolean[] visited = new boolean[topics.length];
        for (int i = 0; i < X; i++) {
            int maxIdx = largestWeightTopic(visited, topics);
            visited[maxIdx] = true;
            weight += topics[maxIdx].W;
        }

        return weight;
    }

    private void subset(int[] input, boolean[] selected, int idx) {
        if (idx == input.length) {
            process(input, selected);
            return;
        }

        // Not selected
        selected[idx] = false;
        subset(input, selected, idx + 1);

        // Selected
        selected[idx] = true;
        subset(input, selected, idx + 1);
    }

    private void process(int[] set, boolean[] selected) {
        double weight = 0;
        double surface = 0;
        for (int i = 0; i < set.length; i++) {
            if (selected[i]) {
                weight += topics[set[i]].W;
                surface += topics[set[i]].S;
            }
        }

        if (surface > A) {
            return;
        }

        if (weight > largestWeight) {
            largestWeight = weight;
        }
    }

    // largestWeight complexity = O(2^N)
    public double largestWeight() {
        int[] input = new int[topics.length];
        boolean[] selected = new boolean[topics.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
            selected[i] = false;
        }

        subset(input, selected, 0);

        return largestWeight;
    }

    public static class Topic {
        double W;
        double S;

        public Topic(double w, double s) {
            W = w;
            S = s;
        }
    }
}
