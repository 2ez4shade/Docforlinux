package 面试题目.代码随想录.链表.设计链表.单链表;

/**
 * @author: shade
 * @date: 2022/4/30 11:50
 * @description:
 */
public class 设计链表 {

}

class MyList {
    int size;
    ListNode head;

    public MyList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    //获取第index个节点的数值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode node = head;
        //位移到index上次数就是index+1次
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.var;
    }

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (val > size) {
            return;
        }
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = new ListNode(val);
        node.next = pre.next;
        pre.next = node;

    }

    //删除链表的第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode node =head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        node.next=node.next.next;
    }


}

class ListNode {
    int var;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int var) {
        this.var = var;
    }
}