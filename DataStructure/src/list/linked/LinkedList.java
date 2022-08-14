package list.linked;

/**
 * 反转链表
 *
 * @author Dozen Lee<br/>
 * 2022/7/8 2:21
 */
public class LinkedList {
    /**
     * 单链表节点
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 双链表节点
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode prev;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 反转单链表
     *
     * @param head 头节点
     * @return 反转后的单链表头节点
     */
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 反转双链表
     *
     * @param head 头节点
     * @return 反转后的双链表头节点
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 删除单链表中的指定值
     *
     * @param head 头节点
     * @param num 指定值
     * @return 删除后的单链表
     */
    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node prev = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
