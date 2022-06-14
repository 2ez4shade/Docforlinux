package 面试题目.代码随想录.链表.两两交换链表中的节点;

/**
 * @author: shade
 * @date: 2022/4/30 15:13
 * @description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = new ListNode(-1);
        newhead.next=head;
        ListNode cur = newhead;
        ListNode left;
        ListNode right;
        ListNode temp;
        while (cur.next != null && cur.next.next != null) {
            left = cur.next;
            right = cur.next.next;
            temp = right.next;
            cur.next = right;
            right.next = left;
            left.next = temp;
            cur = left;
        }
        return newhead.next;
    }
    class Solution2{
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }

}
