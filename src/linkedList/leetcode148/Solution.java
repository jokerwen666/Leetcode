package linkedList.leetcode148;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.06 20:46
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) return null;

        //此算法中的tail结点为分隔后后半段链表中的head结点，故舍去tail
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) fast = fast.next;
        }

        ListNode mid = slow;
        ListNode a = sort(head,mid);
        ListNode b = sort(mid, tail);
        return mergeTwoLists(a,b);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null || b == null)
            return a !=null ? a : b;

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode pA = a;
        ListNode pB = b;

        while(pA != null && pB != null) {
            if (pA.val < pB.val) {
                tail.next = pA;
                pA = pA.next;
            }
            else {
                tail.next = pB;
                pB = pB.next;
            }

            tail = tail.next;
        }

        tail.next = pA == null ? pB : pA;
        return dummyHead.next;
    }
}
