package exams.test01.q1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/7/28 21:00
 */
public class Main {
    public static void main(String[] args) {
        Main solution = new Main();
        TreeNode root = solution.initTree();
        int result = solution.sumOfShallowestLeaves(root);
        System.out.print(result);
    }

    private int sumOfShallowestLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        List<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);
        while (!cur.isEmpty()) {
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode iNode = cur.get(i);
                if (iNode.left == null && iNode.right == null) {
                    res += iNode.val;
                    for (int j = i + 1; j < size; j++) {
                        TreeNode jNode = cur.get(j);
                        if (jNode.left == null && jNode.right == null) {
                            res += jNode.val;
                        }
                    }
                    return res;
                }
            }
            for (int k = 0; k < size; k++) {
                TreeNode kNode = cur.get(0);
                if (kNode.left != null) {
                    cur.add(kNode.left);
                }
                if (kNode.right != null) {
                    cur.add(kNode.right);
                }
                cur.remove(0);
            }
        }
        return res;
    }

    private TreeNode initTree() {
        Scanner scan = new Scanner(System.in);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(new TreeNode(scan.nextInt()));
        TreeNode root = nodes.peek();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int lval = scan.nextInt();
            int rval = scan.nextInt();
            if (lval >= 0) {
                TreeNode lnode = new TreeNode(lval);
                node.left = lnode;
                nodes.offer(lnode);
            }
            if (rval >= 0) {
                TreeNode rnode = new TreeNode(rval);
                node.right = rnode;
                nodes.offer(rnode);
            }
        }
        return root;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int _val) {
        val = _val;
    }
}
