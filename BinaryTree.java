import java.util.*;

public class BinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(){
            left = right = null;
        }

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    private static void preorderHelper(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(Node node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result);
            result.add(node.value);
            inorderHelper(node.right, result);
        }
    }

    // Postorder Traversal
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(Node node, List<Integer> result) {
        if (node != null) {
            postorderHelper(node.left, result);
            postorderHelper(node.right, result);
            result.add(node.value);
        }
    }

    public static List<Integer> levelOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);

            if (node.left != null)
                queue.add(node.left); // Add left child to the queue

            if (node.right != null)
                queue.add(node.right); // Add right child to the queue
        }
        return result;
        }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println("\nSmall Tree: ");
        System.out.println("Preorder: " + preorderTraversal(root));
        System.out.println("Inorder: " + inorderTraversal(root));
        System.out.println("Postorder: " + postorderTraversal(root));
        System.out.println("Level order: " + levelOrderTraversal(root));

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        System.out.println("\nLarger Tree: ");
        System.out.println("Preorder: " + preorderTraversal(root));
        System.out.println("Inorder: " + inorderTraversal(root));
        System.out.println("Postorder: " + postorderTraversal(root));
        System.out.println("Level order: " + levelOrderTraversal(root));

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.left.left = new Node(4);
        root2.left.left.left.left = new Node(5);

        System.out.println("\nSkewed Tree: " );
        System.out.println("Preorder: " + preorderTraversal(root2));
        System.out.println("Inorder: " + inorderTraversal(root2));
        System.out.println("Postorder: " + postorderTraversal(root2));
        System.out.println("Level order: " + levelOrderTraversal(root2));

        System.out.println("\nOnly Root Tree: " );
        Node root3 = new Node(1);
        System.out.println("Preorder: " + preorderTraversal(root3));
        System.out.println("Inorder: " + inorderTraversal(root3));
        System.out.println("Postorder: " + postorderTraversal(root3));
        System.out.println("Level order: " + levelOrderTraversal(root3));

        System.out.println("\nEmpty Tree: " );
        System.out.println("Preorder: " + preorderTraversal(null));
        System.out.println("Inorder: " + inorderTraversal(null));
        System.out.println("Postorder: " + postorderTraversal(null));
        System.out.println("Level order: " + levelOrderTraversal(null));
    }
}
