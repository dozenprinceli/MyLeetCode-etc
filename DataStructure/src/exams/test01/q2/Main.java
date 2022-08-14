package exams.test01.q2;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/7/28 21:30
 */
public class Main {
    public static void main(String[] args) {
        Main solution = new Main();
        Node head = solution.initLinkedList();
        System.out.println("Over");
    }

    private Node sortList(Node head) {
        return null;
    }

    private Node initLinkedList() {
        Scanner scan = new Scanner(System.in);
        String[] nodes = scan.nextLine().split(" ");

        for (String node : nodes) {

        }
        return null;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
