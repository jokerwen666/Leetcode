package linkedList.leetcode21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 22:23
 */
public class Solution {
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode last1 = null;
        ListNode last2 = null;

        while (l1.next != null)
            l1 = l1.next;
        last1 = l1;

        while (l2.next != null)
            l2 = l2.next;
        last2 = l2;

        if (last1.val <= head2.val){
            last1.next = head2;
            return head1;
        }

        if (last2.val <= head1.val){
            last2.next = head1;
            return head2;
        }

        last1.next = head2;
        ListNode cur1 = head1;
        ListNode newHead = new ListNode(head1.val);
        ListNode cur2 = newHead;
        while (cur1.next != null){
            cur2.next = new ListNode(cur1.next.val);
            cur1 = cur2.next;
            cur2 = cur2.next;
        }

        cur1 = head1;
        cur2 = head2;
        ListNode cur3 = newHead;
        while (cur3 != null){
            if (cur1 == head2){
                cur3.val = cur2.val;
                cur3 = cur3.next;
                cur2 = cur2.next;
            }

            else if (cur2 == null){
                cur3.val = cur1.val;
                cur3 = cur3.next;
                cur1 = cur1.next;
            }

            else if(cur1.val <= cur2.val){
                cur3.val = cur1.val;
                cur3 = cur3.next;
                cur1 = cur1.next;
            }

            else {
                cur3.val = cur2.val;
                cur3 = cur3.next;
                cur2 = cur2.next;
            }
        }

        return newHead;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode cur = null;
        if (l1.val <= l2.val) {
            head = l1;
            cur = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            cur = l2;
            l2 = l2.next;

        }

        while (l1 != null || l2 != null) {
            if(l2 == null){
                cur.next = l1;
                l1 = null;
            }

            else if(l1 == null){
                cur.next = l2;
                l2 = null;
            }


            else if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        return head;
    }


}
