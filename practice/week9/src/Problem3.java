import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BST {
        static Node root;

        static Node sortedArrayToBST(int[] arr, int low, int high) {
            if (low > high) return null;

            int middle = (high + low) / 2;
            Node root = new Node(arr[middle]);

            root.left = sortedArrayToBST(arr, low, middle - 1);
            if (root.left != null) root.left.parent = root;
            root.right = sortedArrayToBST(arr, middle + 1, high);
            if (root.right != null) root.right.parent = root;

            return root;
        }

        static void breadthFirstTraversal() {
            Queue<Node> q = new LinkedList<>();

            if (root != null) q.add(root);
            while (!q.isEmpty()) {
                Node current = q.remove();
                System.out.println("Node: " + current.data);
                if (current.left != null) System.out.println("Left: " + current.left.data);
                if (current.right != null) System.out.println("Right: " + current.right.data);
                System.out.println();

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        BST.root = BST.sortedArrayToBST(arr, 0, arr.length - 1);
        BST.breadthFirstTraversal();
    }
}
