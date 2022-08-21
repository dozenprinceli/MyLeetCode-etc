//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则： 
//
// 
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。 
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。 
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。 
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。 
// 继续这一过程，直到树中的所有节点都妥善放置。 
// 任意空单元格都应该包含空字符串 "" 。 
// 
//
// 返回构造得到的矩阵 res 。 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 2¹⁰] 内 
// -99 <= Node.val <= 99 
// 树的深度在范围 [1, 10] 内 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 135 👎 0

import java.util.*;

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
    public List<List<String>> printTree(TreeNode root) {
        int m = getDepth(root); // row
        int depth = m - 1; // height
        int n = (1 << m) - 1; // col
        // 初始化答案矩阵
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> curRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                curRow.add("");
            }
            ans.add(curRow);
        }
        // locList存储当前行的所有节点及其col位置
        List<Object[]> locList = new ArrayList<>();
        locList.add(new Object[]{root, (n - 1) / 2});
        int curRow = 0;
        while (!locList.isEmpty()) {
            int curSize = locList.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = (TreeNode) locList.get(0)[0];
                int curLoc = (int) locList.remove(0)[1];
                ans.get(curRow).set(curLoc, String.valueOf(curNode.val));
                if (curNode.left != null) {
                    locList.add(new Object[]{curNode.left, curLoc - (1 << (depth - curRow - 1))});
                }
                if (curNode.right != null) {
                    locList.add(new Object[]{curNode.right, curLoc + (1 << (depth - curRow - 1))});
                }
            }
            curRow++;
        }
        return ans;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
