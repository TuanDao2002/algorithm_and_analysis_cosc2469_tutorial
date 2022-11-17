public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node2.left = node3;
        node2.right = node3;

        node2.left.left = node4;
        node2.left.right = node5;

        node2.right.left = node5;
        node2.right.right = node4;

        node2.left.right.left = node8;
        node2.left.right.right = node9;

        node2.right.right.left = node9;
        node2.right.right.right = node8;

        System.out.println(isSymmetric(node2));
    }
}
