package exam0901_baidu;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/1 16:05
 */
public class Solution1 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        root.lchild = l1;
        root.rchild = r1;
        l1.lchild = l2;
        System.out.println(getDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        TreeNode l4 = new TreeNode(5);
        TreeNode l5 = new TreeNode(6);
        TreeNode l6 = new TreeNode(7);
        root.lchild = l1;
        l1.lchild = l2;
        l2.lchild = l3;
        l3.lchild = l4;
        l4.lchild = l5;
        l5.lchild = l6;
        System.out.println(getDepth(root));
    }

    class TreeNode {
        int val;
        TreeNode lchild;
        TreeNode rchild;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.lchild == null) {
            return 1 + getDepth(root.rchild);
        }
        if (root.rchild == null) {
            return 1 + getDepth(root.lchild);
        }
        return 1 + Math.min(getDepth(root.lchild), getDepth(root.rchild));
    }

    public int getColSum(String s, int colIdx) {
        String[] strs = s.split("\n");
        int sum = 0;
        for (String row : strs) {
            String[] cells = row.split(" ");
            if (cells.length <= colIdx) {
                continue;
            }
            String[] qs = cells[colIdx].split("=");
            try {
                int cur = Integer.parseInt(qs[qs.length - 1]);
                sum += cur;
            } catch (NumberFormatException ignored) {}
        }
        return sum;
    }
}
