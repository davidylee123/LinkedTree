public class LinkedTree {
    private static class Node {
        private final int key;
        private final String data;
        private Node left;
        private Node right;

        public Node(int key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node root;

    public void preOrderPrint() {
        if (root != null)
            myPreOrderPrint(root);
    }
    private void myPreOrderPrint(Node root) {
        System.out.println(root.key + " ");
        if (root.left != null)
            myPreOrderPrint(root.left);
        if (root.right != null)
            myPreOrderPrint(root.right);
    }

    public String searchR(int key) {
        Node n = searchTreeRecursion(root, key);
        return (n == null ? null : n.data);
    }
    private Node searchTreeRecursion(Node root, int key) {
        if (root == null)
            return null;
        else if (key == root.key)
            return root;
        else if (key < root.key)
            return searchTreeRecursion(root.left, key);
        else
            return searchTreeRecursion(root.right, key);
    }

    public String searchTreeI(int key) {
        Node n = searchTreeIteration(root,key);
        return (n == null) ? null : n.data;
    }
    private Node searchTreeIteration(Node root, int key) {
        Node trav = root;
        while (trav != null) {
            if (key == trav.key) {
                return trav;
            }
            else if (key < trav.key)
                trav = trav.left;
            else
                trav = trav.right;
        }
        return null;
    }

    public void insert(int key, String data) {
        Node parent = null;
        Node trav = root;
        while (trav != null) {
            parent = trav;
            if (key < trav.key)
                trav = trav.left;
            else
                trav = trav.right;
        }
        // Insert the new node
        if (parent == null)
            root = new Node(key, data);
        else if (key < parent.key)
            parent.left = new Node(key, data);
        else
            parent.right = new Node(key, data);
    }

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();

        // Inserting some nodes
        tree.insert(50, "root");
        tree.insert(30, "left child of root");
        tree.insert(70, "right child of root");
        tree.insert(20, "left child of left child of root");
        tree.insert(40, "right child of left child of root");
        tree.insert(60, "left child of right child of root");
        tree.insert(80, "right child of right child of root");

        // Printing the tree using pre-order traversal
        System.out.println("Pre-order traversal of the tree:");
        tree.preOrderPrint();

        // Searching using recursion
        int keyToSearch = 40;
        String resultR = tree.searchR(keyToSearch);
        System.out.println("\nRecursively searching for key " + keyToSearch + ": " + resultR);

        // Searching using iteration
        String resultI = tree.searchTreeI(keyToSearch);
        System.out.println("Iteratively searching for key " + keyToSearch + ": " + resultI);
    }
}
