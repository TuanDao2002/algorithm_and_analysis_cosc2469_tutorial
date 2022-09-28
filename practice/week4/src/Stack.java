import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T item) {
        list.add(item);
    }

    public boolean pop() {
        if (isEmpty()) return false;
        list.remove(list.size() - 1);
        return true;
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public void printStack() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        stack.printStack();

        System.out.println(stack.pop());
        stack.printStack();

        System.out.println(stack.peek());
    }
}
