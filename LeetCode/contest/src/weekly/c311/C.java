package weekly.c311;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/18 10:29
 */
public class C {
    public TreeNode reverseOddLevels(TreeNode root) {
        traverseLayer(Collections.singletonList(root), false);
        return root;
    }

    private void traverseLayer(List<TreeNode> nodes, Boolean bool) {
        if (bool) {
            reverseNodeList(nodes);
        }
        if (nodes.get(0).left == null) {
            return;
        }

        List<TreeNode> ans = new ArrayList<>(nodes.size() * 2);
        for (TreeNode node : nodes) {
            ans.add(node.left);
            ans.add(node.right);
        }
        traverseLayer(ans, !bool);
    }

    private void reverseNodeList(List<TreeNode> nodes) {
        int n = nodes.size();
        for (int i = 0; i < n >> 1; i++) {
            int tmp = nodes.get(i).val;
            nodes.get(i).val = nodes.get(n - i - 1).val;
            nodes.get(n - i - 1).val = tmp;
        }
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
