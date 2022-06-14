package 面试题目.代码随想录.链表.移除链表元素;

/**
 * @author: shade
 * @date: 2022/4/30 11:15
 * @description:
 */
public class 移除链表元素 {

    /**
     * 不用头节点做法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        //写的有点冗余
        //       if (head == null) {
        //         return head;
        //   }
//        ListNode pre = head;
//        while (pre.var == val) {
//            pre = pre.next;
//            if (pre == null) {
//                return pre;
//            }
//        }
        while (head != null && head.var == val) {
            head = head.next;
        }
        if (head==null){
            return head;
        }
        // 已确定当前head.val != val并且不是null
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.var == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 有头节点的做法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //双指针
        ListNode newhead = new ListNode(0, head);
        ListNode pre = newhead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.var == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newhead.next;
    }
}

/**
 * 链表节点类
 */
class ListNode {
    int var;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int var) {
        this.var = var;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int var, ListNode next) {
        this.var = var;
        this.next = next;
    }
}
