package 面试题目.代码随想录.链表.环形链表II;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: shade
 * @date: 2022/4/30 16:04
 * @description:
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode fasttemp = fast;
                ListNode slowtemp = head;
                while (fasttemp != slowtemp) {
                    fasttemp = fasttemp.next;
                    slowtemp = slowtemp.next;
                }
                return fasttemp;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
                node = node.next;
            }
        }
        return node;
    }
}