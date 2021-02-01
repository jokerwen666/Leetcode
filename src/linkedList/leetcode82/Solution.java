package linkedList.leetcode82;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.31 16:07
 */
public class Solution {

    //非递归解法，三指针
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode pos = dummyHead;
        ListNode pre = head;
        ListNode p = head.next;
        int cur = head.val;
        int state = 0;
        while(p != null) {
            if(p.val == cur) state = 1;

            else {
                if(state == 1) {
                    pos.next = p;
                    pre = pos;
                    state = 0;
                }
                pos = pre;
                cur = p.val;
            }
            p = p.next;
            pre = pre.next;
        }
        if(state == 1) pos.next = p;
        return dummyHead.next;
    }

    //递归解法
    //该递归函数的作用是：处理从head开始的链表，删除重复项
    public ListNode deleteDuplicates(ListNode head) {
        //baseCase
        //head开始的链表为空或者只有一个元素，此时不会存在重复返回head
        if(head == null || head.next == null) return head;

        ListNode next = head.next;

        //recursiveCase1
        //当当前值与下一值相等的时候，说明出现重复，此时将next移动到与head不为相等的位置
        //将next作为待处理的链表head，调用递归函数进行处理
        if (head.val == next.val) {
            while (next != null && next.val == head.val)
                next = next.next;
            //因为出现重复项，因此head本身也需要删除，此时将head指向处理好的后续链表
            head = deleteDuplicates(next);
        }

        //recursiveCase2
        //当当前值与下一值不相等的时候，直接将next作为待处理的链表head，调用递归函数进行处理
        else {
            //head不需要删除，head.next指向处理好的后续链表
            head.next = deleteDuplicates(next);
        }

        return head;
    }

}
