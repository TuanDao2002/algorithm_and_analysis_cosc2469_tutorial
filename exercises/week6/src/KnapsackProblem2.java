public class KnapsackProblem2 {
    Item[] items;
    boolean[] bestSubset;
    int maxValue;
    int capacity;

    public KnapsackProblem2(Item[] i, int c) {
        items = i;
        bestSubset = new boolean[i.length];
        capacity = c;
        maxValue = -1;
    }

    public void start() {
        subset(new boolean[items.length], 0);
    }

    void subset(boolean[] selected, int idx) {
        if (idx == items.length) {
            process(selected);
            return;
        }

        // Not selected
        selected[idx] = false;
        subset(selected, idx + 1);

        // Selected
        selected[idx] = true;
        subset(selected, idx + 1);
    }

    void process(boolean[] selected) {
        int w = 0, v = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                w += items[i].weight;
                v += items[i].value;
                if (w > capacity) {
                    return;
                }
            }
        }
        if (v > maxValue) {
            maxValue = v;
            bestSubset = selected.clone();
        }
    }

    void displayBest() {
        StringBuilder res = new StringBuilder("Best subset: ");
        int v = 0;
        for (int i = 0; i < bestSubset.length; i++) {
            if (bestSubset[i]) {
                res.append(i + ", ");
                v += items[i].value;
            }
        }
        res.append("with total value: " + v);
        System.out.println(res);
    }

    public static void main(String[] args) {
        Item[] items = new Item[4];
        items[0] = new Item(7, 42);
        items[1] = new Item(3, 12);
        items[2] = new Item(4, 40);
        items[3] = new Item(5, 25);
        KnapsackProblem2 knapsack = new KnapsackProblem2(items, 10);
        knapsack.start();
        knapsack.displayBest();
    }
}

class Item {
    int weight;
    int value;

    public Item(int w, int v) {
        weight = w;
        value = v;
    }
}
