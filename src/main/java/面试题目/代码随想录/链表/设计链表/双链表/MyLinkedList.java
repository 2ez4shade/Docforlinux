package 面试题目.代码随想录.链表.设计链表.双链表;

/**
 * @author: shade
 * @date: 2022/4/30 12:24
 * @description:
 */
public class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode node;
        //提高效率确定是从那边开始遍历
        if (index < (size - 1) / 2) {
            node = head;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = 0; i <= size - index - 1; i++) {
                node = node.next;
            }
        }
        return node.var;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        node.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        size++;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next.pre = node;
        cur.next = node;
        node.pre = cur;

    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.pre.next=cur.next;
        cur.next.pre=cur.pre;
        size--;
    }
}

class ListNode {
    int var;
    ListNode pre;
    ListNode next;

    public ListNode(int var) {
        this.var = var;
    }
}