package codeforces.com.rated.r2167div4;

import java.util.*;

public class F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Map<Integer, TreeNode> nodeMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                nodeMap.put(j + 1, new TreeNode(j + 1));
            }
            for (int j = 0; j < n - 1; j++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                nodeMap.get(v1).siblings.add(nodeMap.get(v2));
                nodeMap.get(v2).siblings.add(nodeMap.get(v1));
            }
            process(nodeMap, k);
        }
    }

    private static void process(Map<Integer, TreeNode> nodeMap, int k) {
        int n = nodeMap.size();
        TreeNode root = nodeMap.get(1);
        updateLeafCount(root, 0);
        long total = 0;
        for (TreeNode node : nodeMap.values()) {
            if (n - node.leafCount >= k) total += node.leafCount;
            if (node.leafCount >= k) total += n - node.leafCount;
        }
        System.out.println(total + n);
    }

    /**
     * 获取叶子结点数量
     */
    private static void updateLeafCount(TreeNode root, int parent) {
        for (TreeNode node : root.siblings) {
            if (node.id == parent) continue;
            updateLeafCount(node, root.id);
            root.leafCount += node.leafCount;
        }
    }

    private static class TreeNode {
        List<TreeNode> siblings = new LinkedList<>();
        int id;
        int leafCount = 1;

        public TreeNode(int id) {
            this.id = id;
        }
    }
}
