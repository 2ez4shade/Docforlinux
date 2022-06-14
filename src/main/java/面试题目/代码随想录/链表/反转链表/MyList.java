package 面试题目.代码随想录.链表.反转链表;

/**
 * @author: shade
 * @date: 2022/4/30 13:48
 * @description:
 */
public class MyList {
    int size;
    ListNode head;

    public MyList() {
        size = 0;
        head = new ListNode(-1);
    }

    /**
     * 双指针发
     */
    public void reserveList() {
        ListNode pre = null;
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = pre;
    }

    /**
     * 递归法
     */
    public void reserveList2() {
        resrve(null,head.next);
    }

    public void resrve(ListNode pre, ListNode cur) {
        if (cur == null) {
            head.next = pre;
        }
        ListNode temp;
        temp = cur.next;
        cur.next=pre;
        resrve(cur,temp);
    }
}

class ListNode {
    int var;
    ListNode next;

    public ListNode(int var) {
        this.var = var;
    }
}
