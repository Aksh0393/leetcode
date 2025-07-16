class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class Tree {
    // Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) {
        // your code
        if(node ==null) return true;
        return solve(node.left, node.right);
    }

    private boolean solve(Node left, Node right) {
        if(left ==null && right ==null) return true;

        if(left ==null || right ==null) return false;

        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}