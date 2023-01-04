import java.util.Arrays;

public class LongestIncreasingOrder {
    public static void main(String[] args) {
        int[] test = {5, 2, 3, 9, 6, 7, 8};
//        int[] test = {5, 4, 3, 2, 1};
        int[] res = longestIncreasingSubsequence(test);
        print(res);
    }

    static int[] longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;

        int[] maxCount = new int[n];
        // maxCount[i] stores the length of the longest increasing subsequence ending at i
        // maxCount[i] must be at least 1 (the subsequence contains only element i)
        for (int i = 0; i < n; i++) {
            maxCount[i] = 1;
        }

        int[] prevElement = new int[n];
        // prevElement[i] stores the index of the previous element of the
        // longest increasing subsequence that ends at element i
        // use this array to trace back to the first element
        for (int i = 0; i < n; i++) {
            prevElement[i] = -1;
        }

        // calculate the longest increasing subsequence for all ending elements
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // we can expand the subsequence ends at j-th
                    // to include the element i-th
                    if (maxCount[i] < maxCount[j] + 1) {
                        maxCount[i] = maxCount[j] + 1;
                        prevElement[i] = j;
                    }
                }
            }
        }

        // get the longest subsequence
        // the longest subsequence has to end at one of the element 0 -> (n-1)
        int maxEnding = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxCount[maxEnding] < maxCount[i]) {
                maxEnding = i;
            }
        }

        // Go backward from maxEnding index to the first element
        LinkedListStack<Integer> elements = new LinkedListStack<Integer>();
        do {
            // in this implementation, the values of the elements in the
            // longest increasing subsequence are returned
            // you can change the assignment below to return the indices
            // of the elements instead, i.e., elements.push(maxEnding);
            elements.push(arr[maxEnding]);
            maxEnding = prevElement[maxEnding];
        } while (maxEnding != -1);

        // prepare result
        int[] res = new int[elements.size()];
        int idx = 0;
        while (!elements.isEmpty()) {
            res[idx] = elements.peek();
            elements.pop();
            idx++;
        }
        return res;
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int n : arr) {
            if (!first) {
                sb.append(", " + n);
            } else {
                sb.append(n);
                first = false;
            }
        }
        System.out.println(sb);
    }

    // Singly Linked List-based implementation of stack
    public static class LinkedListStack<T> {
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

        public LinkedListStack() {
            size = 0;
            head = null;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean push(T item) {
            // add a new node at the beginning
            Node<T> node = new Node<T>(item);
            if (!isEmpty()) {
                node.next = head;
            }
            head = node;
            size++;
            return true;
        }

        public boolean pop() {
            // remove the first node
            // make sure the stack is not empty
            if (isEmpty()) {
                return false;
            }
            // advance head
            head = head.next;
            size--;
            return true;
        }

        public T peek() {
            // make sure the stack is not empty
            if (isEmpty()) {
                return null;
            }
            return head.data;
        }
    }
}
