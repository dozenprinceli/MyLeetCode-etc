//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 91 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        List<TreeNode> nodes = Arrays.asList(root);
        while (true) {
            List<TreeNode> nextLevel = nextLevelNodes(nodes);
            if (nextLevel.size() != 0) {
                nodes = nextLevel;
            } else {
                break;
            }
        }
        for (TreeNode node : nodes) {
            sum += node.val;
        }
        return sum;
    }

    private List<TreeNode> nextLevelNodes(List<TreeNode> nodes) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
