class RMITStudent {

    String studentId;
    String fullName;
    String major;
    double GPA;

    public RMITStudent(String studentId, String fullName, String major, double GPA) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.GPA = GPA;
    }
}

// Singly Linked List-based implementation of queue
class LinkedListQueue<T> {
    // this class is used as a container of data
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public LinkedListQueue() {
        size = 0;
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enQueue(T item) {
        // add a new node at the beginning
        Node<T> n = new Node<T>(item);
        n.next = head;
        head = n;
        size++;
        return true;
    }

    public boolean deQqueue() {
        // remove the last node
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
            size = 0;
            return true;
        }
        Node<T> prev = head;
        Node<T> current = prev.next;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        size--;
        return true;
    }

    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.data;
    }
}

public class Problem2 {
    class ADT {
        static int N = 14;
        static LinkedListQueue<RMITStudent>[] hashTable = new LinkedListQueue[N];

        public ADT() {
            for (int i = 0; i < N; i++) {
                hashTable[i] = new LinkedListQueue<>();
            }
        }

        private int hashFunction(String str) {
            int index = 0;
            int strLen = str.length();
            for (int i = 0; i < strLen; i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    index += (c - '0') + 26;
                } else {
                    index += str.charAt(i) - 65;
                }
            }

            index %= N;
            return index;
        }

        boolean put(RMITStudent s) {
            String id = s.studentId;
            int findIndex = hashFunction(id);
            if (hashTable[findIndex].peekFront().studentId.equals(id)) {
                return false;
            } else {
                hashTable[findIndex].enQueue(s);
                return true;
            }
        }

        RMITStudent get(String studentID) {
            int findIndex = hashFunction(studentID);
            LinkedListQueue<RMITStudent> linkedListQueue = hashTable[findIndex];
            if (linkedListQueue.isEmpty()) return null;
            while (!linkedListQueue.isEmpty()) {
                if (linkedListQueue.peekFront().studentId.equals(studentID)) return linkedListQueue.peekFront();
                linkedListQueue.deQqueue();
            }

            return null;
        }
    }

    public static void main(String[] args) {
    }
}