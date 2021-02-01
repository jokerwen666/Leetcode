package linkedList.leetcode52;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.31 22:59
 */
public class Solution {

    /*
    设A链表在交点前路径长度LA，B链表在交点前路径长度LB，公共路径C（C可为空，此时不相交）
    那么很容易得到LA + C + LB = LB + C + LA
    因此让a达到A链表末尾时，指向B链；因此让b达到B链表末尾时，指向A链
    如果有交点，则在交点处相遇；如果没有交点，则最后同时为null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
