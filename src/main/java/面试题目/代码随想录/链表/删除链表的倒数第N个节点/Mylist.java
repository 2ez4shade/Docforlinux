package 面试题目.代码随想录.链表.删除链表的倒数第N个节点;

/**
 * @author: shade
 * @date: 2022/4/30 14:23
 * @description:
 */
public class Mylist {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode slow = newhead;
        ListNode fast = newhead;
        ListNode pre = null;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        //释放掉指针
        slow.next = null;
        return newhead.next;
    }
}

class Solution {
    // method: 递归
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head,n) == n ? head.next : head; // 返回执行完操作后的头节点为原链表(未删除前的原始链表)的倒数第几个,
        // 如果头节点是原链表的倒数第 n 个(即所删除的节点为原链表的头节点),
        // 则新的头节点为原头节点(head)的下一个, 否则仍然是原链表的头节点;
    }
    public int removeNode(ListNode node, int n) {
        if(node.next == null)  return 1;    // 找到最后一个节点(利用最后一个节点的 next 为 null), 记为倒数第 "1" 个, 并结束递归;
        int m = removeNode(node.next, n);   // m 表示当前节点的下一个节点为倒数第几个, 放入下一个节点执行递归, 得到的结果为下一个节点的倒数第几个;
        if(m == n){              // 如果当前节点的下一个节点即为倒数第 m (或者 n )个,
            // 说明我们找到了需要删除的节点(即为当前节点的下一个节点), 于是开始进行操作:
            if(m == 1) {         //      如果要删除的节点(当前节点的下一个节点)为整个链表的倒数第1个:
                node.next = null;//          我们只需让当前节点的 next 为 null, 即看作是执行删除需要删除的节点;
            } else {             //      如果要删除的节点(当前节点的下一个节点)不为整个链表的最后一个节点(即需要删除的节点之后还有别的节点):
                node.next = node.next.next;//我们只需要让当前节点的 next 指向要删除的节点的下一个节点即可;
            }
        } // 当前节点的下一个节点不是要删除的对象时不执行操作, 或者完成删除指定节点的操作
        return m+1;                             // 由于 m 表示的是当前节点的下一个节点为倒数第几个, 所以此处为返回当前节点为倒数第几个(m + 1),
        // 并且值得注意的是, 是否已执行删除节点并不影响(未改变) m 的值, m+1 即该节点为原链表的倒数第几个;
    }
}


