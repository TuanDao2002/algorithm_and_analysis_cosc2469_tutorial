public class EscapeRoom {
    public class ArrayStack<T> {
        private int size;
        private static int MAX_SIZE = 100;
        private T[] items;

        public ArrayStack() {
            size = 0;
            items = (T[]) new Object[MAX_SIZE];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean push(T item) {
            // make sure the stack still have empty slot
            if (size < MAX_SIZE) {
                items[size] = item;
                size++;
                return true;
            }
            return false;
        }

        public boolean pop() {
            // make sure the stack is not empty
            if (isEmpty()) {
                return false;
            }
            size--;
            return true;
        }

        public T peek() {
            // make sure the stack is not empty
            if (isEmpty()) {
                return null;
            }
            return items[size - 1];
        }

        public void display() {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) continue;
                System.out.print(items[i] + " ");
            }
        }
    }

    ArrayStack<String> rooms = new ArrayStack<>();

    public EscapeRoom() {}

    void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("empty");
            return;
        }
        rooms.display();
        System.out.println();
    }

    // addNewRoom complexity = O(1)
    void addNewRoom(String room) {
        rooms.push(room);
    }

    // exitRoom complexity = O(1)
    String exitRoom() {
        if (rooms.isEmpty()) return null;
        String lastEnteredRoom = rooms.peek();
        rooms.pop();
        return lastEnteredRoom;
    }


    int minOperations(String[] target, String[] enteredRooms) {
        ArrayStack<String> enteredStack = new ArrayStack<>();
        for (String room : enteredRooms) {
            enteredStack.push(room);
        }

        ArrayStack<String> targetStack = new ArrayStack<>();
        for (String room : target) {
            targetStack.push(room);
        }

        int min = 0;
        while (!enteredStack.isEmpty() || !targetStack.isEmpty()) {
            String enteredRoom = enteredStack.peek();
            String targetRoom = targetStack.peek();

            if (!enteredRoom.equals(targetRoom)) {
                if (enteredStack.size >= targetStack.size) {
                    enteredStack.pop();
                } else {
                    targetStack.pop();
                }

                min++;
            } else {
                if (enteredStack.size != targetStack.size()) {
                    min++;
                }
                enteredStack.pop();
                targetStack.pop();
            }
        }

        return min;
    }

    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.addNewRoom("A");
        escapeRoom.addNewRoom("B");
        escapeRoom.displayRooms();

        System.out.println(escapeRoom.exitRoom());
        System.out.println(escapeRoom.exitRoom());
        escapeRoom.displayRooms();

        System.out.println(escapeRoom.minOperations(new String[]{"A", "B", "C"}, new String[]{"A", "C", "B"}));
        System.out.println(escapeRoom.minOperations(new String[]{"A", "B", "C"}, new String[]{"A", "B", "C", "D"}));
    }
}
