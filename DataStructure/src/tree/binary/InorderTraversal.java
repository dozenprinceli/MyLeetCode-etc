package tree.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @author Dozen Lee<br/>
 * 2022/8/1 3:51
 */
@SuppressWarnings("unused")
public class InorderTraversal {
    /**
     * 递归算法<br/>
     * 时间复杂度: O(n), n为二叉树的节点数<br/>
     * 空间复杂度: O(n), 取决于二叉树的深度, 最差情况当二叉树为一条链时为O(n)
     */
    public static List<Integer> recurseMethod(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurseHelper(root, result);
        return result;
    }

    /**
     * 递归算法Helper
     */
    public static void recurseHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recurseHelper(root.left, list);
        list.add(root.val);
        recurseHelper(root.right, list);
    }

    /**
     * 利用栈实现非递归算法<br/>
     * 时间复杂度: O(n), n为二叉树的节点数<br/>
     * 空间复杂度: O(n), 取决于二叉树的深度, 最差情况当二叉树为一条链时为O(n)
     */
    public static List<Integer> stackMethod(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * Morris算法<br/>
     * 时间复杂度: O(2n)=O(n), n为二叉树的节点数<br/>
     * 空间复杂度: O(1)
     */
    public static List<Integer> morrisMethod(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // root的前继节点(即遍历到root前的最后一个节点)
        TreeNode predecessor;

        while (root != null) {
            if (root.left != null) {
                // 找root的前继节点predecessor
                predecessor = root.left;
                while (predecessor.right != root && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // 若predecessor无right, 继续遍历left
                if (predecessor.right == null) {
                    // 将predecessor的right指向root
                    predecessor.right = root;
                    // root移动到left上继续遍历
                    root = root.left;
                } else {
                    // 左子树遍历结束, 加入root
                    result.add(root.val);
                    // 重置predecessor的right
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // 没有left, 加入自身后访问right
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }
}

@SuppressWarnings("unused")
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