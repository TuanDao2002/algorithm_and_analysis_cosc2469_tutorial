class WaterJugs {
    // Solving the water jug problem with BFS
    static void BFS(SearchState begin, int target, int firstMax, int secondMax) {
        LinkedListQueue<SearchState> queue = new LinkedListQueue<>();
        boolean[][] visited = new boolean[firstMax + 1][secondMax + 1];
        SearchState.FIRST_MAX = firstMax;
        SearchState.SECOND_MAX = secondMax;

        queue.enQueue(begin);
        visited[begin.first][begin.second] = true;

        while (!queue.isEmpty()) {
            SearchState current = queue.peekFront();
            queue.deQqueue();
            if (current.first == target || current.second == target) {
                // construct the solution from current to the beginning

                String solution = "";
                // should use StringBuilder to make it faster
                while (current != null) {
                    solution = String.format("%d %d - %s\n", current.first, current.second, current.howto) + solution;
                    current = current.parent;
                }
                System.out.println(solution);
                return;
            }
            SearchState[] nextStates = current.generate();
            for (int i = 0; i < nextStates.length; i++) {
                if (nextStates[i] == null) {
                    break;
                }
                if (visited[nextStates[i].first][nextStates[i].second]) {
                    continue;
                }
                queue.enQueue(nextStates[i]);
                visited[nextStates[i].first][nextStates[i].second] = true;
            }
        }
        System.out.println("No solution");
    }

    public static void main(String[] args) {
        SearchState s = new SearchState(0, 0, null, null);
        WaterJugs.BFS(s, 7, 8, 10);
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

class SearchState {
    static int FIRST_MAX = 3;
    static int SECOND_MAX = 4;
    int first, second;
    SearchState parent;
    String howto;

    public SearchState(int f, int s, SearchState p, String h) {
        first = f;
        second = s;
        parent = p;
        howto = h;
    }

    public SearchState[] generate() {
        // at most six new states can be generated
        SearchState[] res = new SearchState[6];
        int idx = 0;
        // empty first
        if (first > 0) {
            res[idx++] = new SearchState(0, second, this, "Empty First");
        }

        // empty second
        if (second > 0) {
            res[idx++] = new SearchState(first, 0, this, "Empty Second");
        }

        // fill first
        if (first < FIRST_MAX) {
            res[idx++] = new SearchState(FIRST_MAX, second, this, "Fill First");
        }

        // fill second
        if (second < SECOND_MAX) {
            res[idx++] = new SearchState(first, SECOND_MAX, this, "Fill Second");
        }

        // pour first to second
        if (first > 0) {
            if (first + second <= SECOND_MAX) {
                res[idx++] = new SearchState(0, first + second, this, "Pour First to Second");
            } else {
                res[idx++] = new SearchState(first + second - SECOND_MAX, SECOND_MAX, this, "Pour First to Second");
            }
        }

        // pour second to first
        if (second > 0) {
            if (first + second <= FIRST_MAX) {
                res[idx++] = new SearchState(first + second, 0, this, "Pour Second to First");
            } else {
                res[idx++] = new SearchState(FIRST_MAX, first + second - FIRST_MAX, this, "Pour Second to First");
            }
        }
        return res;
    }
}
