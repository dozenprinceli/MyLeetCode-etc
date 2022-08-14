//给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。 
//
// 返回包含原始树中所有 最深节点 的 最小子树 。 
//
// 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。 
//
// 一个节点的 子树 是该节点加上它的所有后代的集合。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：
//我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点。 
//
// 示例 3： 
//
// 
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在
// [1, 500] 范围内。 
// 0 <= Node.val <= 500 
// 每个节点的值都是 独一无二 的。 
// 
//
// 
//
// 注意：本题与力扣 1123 重复：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//deepest-leaves 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 175 👎 0

import java.util.ArrayList;
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<List<TreeNode>> chains = dfs(root);
        int depth = 0;
        for (List<TreeNode> chain : chains) {
            depth = Math.max(depth, chain.size());
        }
        for (int i = chains.size() - 1; i >=0; i--) {
            if (chains.get(i).size() != depth) {
                chains.remove(i);
            }
        }
        boolean isSame = false;
        for (int i = 0; i < depth; i++) {
            isSame = true;
            int sameVal = chains.get(0).get(i).val;
            for (List<TreeNode> chain : chains) {
                if (chain.get(i).val != sameVal) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                TreeNode result = chains.get(0).get(i);
                return result;
            }
        }
        return null;
    }

    private List<List<TreeNode>> dfs(TreeNode node) {
        if (node == null) {
            List<List<TreeNode>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if (node.left == null && node.right == null) {
            List<List<TreeNode>> res = new ArrayList<>();
            List<TreeNode> sub = new ArrayList<>();
            sub.add(node);
            res.add(sub);
            return res;
        }
        List<List<TreeNode>> left = dfs(node.left);
        List<List<TreeNode>> right = dfs(node.right);
        for (List<TreeNode> lst : left) {
            lst.add(node);
        }
        for (List<TreeNode> lst : right) {
            lst.add(node);
        }
        List<List<TreeNode>> res = new ArrayList<>();
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
