package linkedList.leetcode1669;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.01 17:12
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = list2;
        ListNode cur = list1;

        for (int i = 0; i < a-1; i++)
            cur = cur.next;
        p1 = cur;

        for (int i = 0; i < b-a+1; i++)
            cur = cur.next;
        p2 = cur;

        while (p3.next != null)
            p3 = p3.next;

        p1.next = list2;
        p3.next = p2.next;
        p2.next = null;

        return list1;
    }
}
