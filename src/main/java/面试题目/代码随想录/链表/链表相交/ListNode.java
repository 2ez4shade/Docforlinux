package 面试题目.代码随想录.链表.链表相交;

/**
 * @author: shade
 * @date: 2022/4/30 15:29
 * @description:
 */


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            a++;
            A = A.next;
        }
        while (B != null) {
            b++;
            B = B.next;
        }
        A = headA;
        B = headB;
        //让A是长的那条
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
            ListNode tempnode = A;
            A = B;
            B = tempnode;
        }
        //把长度统一
        int offset = a - b;
        for (int i = 0; i < offset; i++) {
            A = A.next;
        }
        while (A != B) {
            A = A.next;
            B = B.next;
            if (A==null){
                return null;
            }
        }
        return A;
    }

    /**
     * 大佬的写法
     * 设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有
     *
     * a + c + b = b + c + a
     * 若无交集，则a + b = b + a
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }
}
