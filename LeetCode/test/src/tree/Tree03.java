package tree;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/2 0:29
 */
public class Tree03 {
    @Test
    public void test687() {
        TreeNode root = new TreeNode(1);
        TreeNode r11 = new TreeNode(4);
        TreeNode r12 = new TreeNode(5);
        TreeNode r21 = new TreeNode(4);
        TreeNode r22 = new TreeNode(4);
        TreeNode r23 = new TreeNode(5);
        root.left = r11;
        root.right = r12;
        r11.left = r21;
        r11.right = r22;
        r22.right = r23;
        System.out.println(longestUnivaluePath(root));
    }

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lLen = 0, rLen = 0;
        if (root.left != null && root.left.val == root.val) {
            lLen = helper(root.left) + 1;
        } else {
            helper(root.left);
        }
        if (root.right != null && root.right.val == root.val) {
            rLen = helper(root.right) + 1;
        } else {
            helper(root.right);
        }
        max = Math.max(lLen + rLen, max);
        return Math.max(lLen, rLen);
    }
}
