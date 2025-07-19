// public class Solution {
//     public String tree2str(TreeNode root) {
//         if (root == null) {
//             return "";
//         }

//         String result = Integer.toString(root.val);
//         String l = tree2str(root.left);
//         String r = tree2str(root.right);

//         if (root.left == null && root.right == null) {
//             return result;
//         }

//         if (root.right == null) {
//             return result + "(" + l + ")";
//         }

//         if (root.left == null) {
//             return result + "()" + "(" + r + ")";
//         }

//         return result + "(" + l + ")" + "(" + r + ")";
//     }
// }



class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val);

        if (root.left == null && root.right == null)
            return;

        sb.append('(');
        if (root.left != null)
            buildString(root.left, sb);

        sb.append(')');

        if (root.right != null) {
            sb.append('(');
            buildString(root.right, sb);
            sb.append(')');
        }
    }
}
