//设计实现双端队列。 
//
// 实现 MyCircularDeque 类: 
//
// 
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。 
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。 
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。 
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。 
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。 
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。 
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。 
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。 
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次 
// 
//
// Related Topics 设计 队列 数组 链表 👍 127 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {

    private static class LinkedNode {
        int val; // -1表示表头node
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    private final LinkedNode head;
    private int curSize;
    private final int maxSize;

    public MyCircularDeque(int k) {
        head = new LinkedNode(-1);
        head.next = head;
        head.prev = head;
        curSize = 0;
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            LinkedNode oldNext = head.next;
            LinkedNode newNext = new LinkedNode(value);
            head.next = newNext;
            newNext.next = oldNext;
            newNext.prev = head;
            oldNext.prev = newNext;
            curSize++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            LinkedNode oldPrev = head.prev;
            LinkedNode newPrev = new LinkedNode(value);
            head.prev = newPrev;
            newPrev.prev = oldPrev;
            oldPrev.next = newPrev;
            newPrev.next = head;
            curSize++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            head.next.next.prev = head;
            head.next = head.next.next;
            curSize--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
            curSize--;
            return true;
        }
        return false;
    }

    public int getFront() {
        if (!isEmpty()) {
            return head.next.val;
        }
        return -1;
    }

    public int getRear() {
        if (!isEmpty()) {
            return head.prev.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
