package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/22 15:42
 */
public class Tree01 {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(10);
        Node node5 = new Node(-100);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node3.right = node5;
        System.out.println(getMaxPath(root));
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int getMaxPath(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }

        int leftSum = node.left == null ? Integer.MIN_VALUE : getMaxPath(node.left);
        int rightSum = node.right == null ? Integer.MIN_VALUE : getMaxPath(node.right);
        return Math.max(leftSum, rightSum) + node.value;
    }
}
