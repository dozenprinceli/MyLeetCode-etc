package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 0:18
 */
public class Tree02 {
    @Test
    public void test662() {
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(5);
        TreeNode node22 = new TreeNode(3);
        TreeNode node23 = new TreeNode(9);
        root.left = node11;
        root.right = node12;
        node11.left = node21;
        node11.right = node22;
        node12.right = node23;
        System.out.println(widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        List<TreeNode> curRow = new ArrayList<>();
        curRow.add(root);
        while (true) {
            int curWidth = getWidth(curRow);
            if (curWidth == 0) {
                break;
            }
            ans = Math.max(ans, curWidth);
            curRow = getNextRow(curRow);
        }
        return ans;
    }

    private List<TreeNode> getNextRow(List<TreeNode> nodes) {
        List<TreeNode> ans = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node == null) {
                ans.add(null);
                ans.add(null);
            } else {
                ans.add(node.left);
                ans.add(node.right);
            }
        }
        return ans;
    }

    private int getWidth(List<TreeNode> nodes) {
        int ans = nodes.size();
        int ptr = 0;
        while (ptr < nodes.size()) {
            if (nodes.get(ptr) == null) {
                ans--;
            } else {
                break;
            }
            ptr++;
        }
        if (ans == 0) {
            return 0;
        }
        ptr = nodes.size() - 1;
        while (true) {
            if (nodes.get(ptr) == null) {
                ans--;
            } else {
                break;
            }
            ptr--;
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
