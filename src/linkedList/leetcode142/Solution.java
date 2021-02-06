package linkedList.leetcode142;

import linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.01 18:07
 */
public class Solution {
    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        Set<ListNode> set = new HashSet<>();
        set.add(head);

        while (head.next != null) {
            if (set.contains(head.next)) break;

            set.add(head.next);
            head = head.next;
        }

        return head.next;
    }

    //使用快慢指针的方法
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean loop = false;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                loop = true;
                break;
            }
        }

        if(!loop) return null;

        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }

}
