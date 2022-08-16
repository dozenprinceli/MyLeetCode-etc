//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 272 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = Arrays.asList(root);
        while (nodes.size() != 0) {
            int max = Integer.MIN_VALUE;
            for (TreeNode node : nodes) {
                max = Math.max(max, node.val);
            }
            res.add(max);
            nodes = helper(nodes);
        }
        return res;
    }

    private List<TreeNode> helper(List<TreeNode> nodes) {
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
