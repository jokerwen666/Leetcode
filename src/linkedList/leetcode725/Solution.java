package linkedList.leetcode725;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.01 17:10
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int len = 0;
        while(p != null) {
            len++;
            p = p.next;
        }

        int m = len / k;
        int n = len % k;
        ListNode[] res = new ListNode[k];
        ListNode head = root;
        ListNode tail = root;
        int i = 0;

        while (head != null || i < k) {
            if (head == null) {
                res[i] = null;
                i++;
                continue;
            }

            int size = n > 0 ? m : m-1;
            while (size != 0) {
                tail = tail.next;
                size--;
            }
            ListNode temp = tail;
            tail = tail.next;
            temp.next = null;
            res[i] = head;
            head = tail;

            n--;
            i++;
        }

        return res;
    }
}
