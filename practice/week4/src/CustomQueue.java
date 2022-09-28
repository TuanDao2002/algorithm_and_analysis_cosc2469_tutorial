import java.util.ArrayList;

public class CustomQueue<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(T item) {
        list.add(item);
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        list.remove(0);
        return true;
    }

    public T front() {
        return list.get(0);
    }

    public void printQueue() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.deQueue());
        for (int i = 0; i < 10; i++) {
            customQueue.enQueue(i);
        }
        customQueue.printQueue();

        System.out.println(customQueue.deQueue());
        customQueue.printQueue();

        System.out.println(customQueue.front());
    }
}
