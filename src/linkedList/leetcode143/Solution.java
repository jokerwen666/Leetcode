package linkedList.leetcode143;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.30 22:25
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //将链表从中间分开
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //链表后半部分翻转
        ListNode newHead = reverse(slow.next);
        ListNode p1 = head;
        ListNode p2 = newHead;
        slow.next = null;

        //重新组装两部分
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = temp;
        }

    }


    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (head != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }
}
