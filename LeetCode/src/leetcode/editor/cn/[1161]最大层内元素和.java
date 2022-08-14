//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 10⁴]范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 95 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int cnt = 1;
        int res = 1;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        sumHelper(nodes);
        while (!nodes.isEmpty()) {
            cnt++;
            int cur = sumHelper(nodes);
            if (cur > max) {
                res = cnt;
                max = cur;
            }
        }
        return res;
    }

    private Integer sumHelper(Queue<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        int sum = 0;
        int size = nodes.size();
        for (int i = 0; i < size; ++i) {
            TreeNode root = nodes.poll();
            sum += root.val;
            if (root.left != null) {
                nodes.offer(root.left);
            }
            if (root.right != null) {
                nodes.offer(root.right);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
