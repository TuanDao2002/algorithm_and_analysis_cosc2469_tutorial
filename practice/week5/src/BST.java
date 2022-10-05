import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static class Node {
        int data;
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }

    static class BinaryTree {
        static Node root;

        static Node sortedArrayToBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = (start + end) / 2;
            Node node = new Node(arr[mid]);

            node.left = sortedArrayToBST(arr, start, mid - 1);
            if (node.left != null) node.left.parent = node;
            node.right = sortedArrayToBST(arr, mid + 1, end);
            if (node.right != null) node.right.parent = node;

            return node;
        }

        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.printf("%d (%d) ", node.data, node.parent != null ? node.parent.data : -1);
                inOrder(node.right);
            }
        }

        void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + " ");
            }
        }

        void breadthFirstTraversal() {
            Queue<Node> q = new LinkedList<>();

            if (root != null) q.add(root);
            while (!q.isEmpty()) {
                Node current = q.remove();
                System.out.printf("%d (%d) ", current.data, current.parent != null ? current.parent.data : -1);
                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }

        int getHeight(Node node) {
            if (node == null) return 0;

            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        boolean insert(int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                Node parent = null;
                Node current = root;

                while (current != null) {
                    if (value < current.data) {
                        parent = current;
                        current = current.left;
                        continue;
                    }

                    if (value > current.data) {
                        parent = current;
                        current = current.right;
                        continue;
                    }

                    return false; // already exist
                }

                if (value < parent.data) {
                    parent.left = new Node(value);
                    parent.left.parent = parent;
                } else {
                    parent.right = new Node(value);
                    parent.right.parent = parent;
                }
            }

            return true;
        }

        Node find(int x) {
            Node node = root;
            int numberOfSteps = 0;
            while (node != null) {
                if (x > node.data) {
                    node = node.right;
                    numberOfSteps++;
                    continue;
                } else if (x < node.data){
                    node = node.left;
                    numberOfSteps++;
                    continue;
                }

                System.out.printf("Number of steps to find %d : %d\n", node.data, numberOfSteps);
                return node;
            }

            return null;
        }

        boolean isBST(Node node, int min, int max) {
            if (node == null) return true;

            // false if node data is not in the required range
            if (node.data < min || node.data > max) return false;

            // each node is greater than all nodes in left subtree and smaller than all nodes in right subtree
            return isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max);
        }

        public static void main(String[] args) {
            BinaryTree binaryTree = new BinaryTree();
            int[] arr = new int[]{1,2,3,4,5,7};
            root = sortedArrayToBST(arr, 0, arr.length - 1);

            System.out.println("Breadth first traversal:");
            binaryTree.breadthFirstTraversal();

            System.out.println("\nPreorder traversal:");
            binaryTree.preOrder(root);

            System.out.println("\nInorder traversal:");
            binaryTree.inOrder(root);

            System.out.println("\nPostorder traversal:");
            binaryTree.postOrder(root);

            System.out.println("\nHeight of binary tree: " + binaryTree.getHeight(root));

            binaryTree.insert(6);
            binaryTree.insert(8);
            binaryTree.insert(10);
            binaryTree.insert(9);
            binaryTree.insert(11);

            binaryTree.find(11);
            binaryTree.find(6);
            binaryTree.breadthFirstTraversal();

            System.out.println("\nHeight of binary tree: " + binaryTree.getHeight(root));
            if (binaryTree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println("This is binary search tree");
            } else {
                System.out.println("This is not binary search tree");
            }
        }
    }
}
