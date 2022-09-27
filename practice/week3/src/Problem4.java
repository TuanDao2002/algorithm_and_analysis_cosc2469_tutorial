import java.util.Scanner;

class CircularLinkedList {
    static Node head, tail;
    int length;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            length += 1;
            return;
        }

        tail.next = newNode;
        tail = tail.next;
        tail.next = head;
        length += 1;
    }

    void deleteFirst() {
        Node previous = head, firstNode = head;

        // Check if list doesn't have any node
        // if not then return
        if (head == null) {
            System.out.print("\nList is empty\n");
            return;
        }

        // Check if list have single node
        // if yes then delete it and return
        if (previous.next == previous) {
            head = null;
            return;
        }

        // Traverse second node to first
        while (previous.next != head) {
            previous = previous.next;
        }

        // Now previous is last node and
        // first node(firstNode) link address
        // put in last node(previous) link
        previous.next = firstNode.next;

        // Make second node as head node
        head = previous.next;
    }

    void remove(int index) {
        if (index == 0) {
            deleteFirst();
        }

        if (index > 0) {
            Node prev = getNode(index - 1);
            Node current = prev.next;
            prev.next = current.next;
        }

        length--;
    }

    Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    static void findJosephusIndex(int size, int k) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        for (int i = 1; i <= size; i++) {
            circularLinkedList.append(i);
        }

        circularLinkedList.printList();

        int index = 0;
        while (circularLinkedList.length > 1) {
            index = (index + k - 1) % circularLinkedList.length;
            circularLinkedList.remove(index);
            circularLinkedList.printList();
        }

        System.out.println("The survival is:");
        circularLinkedList.printList();
    }

    void printList() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size: ");
        int size = scanner.nextInt();
        System.out.println("Step: ");
        int k = scanner.nextInt();
        CircularLinkedList.findJosephusIndex(size, k);
    }
}

