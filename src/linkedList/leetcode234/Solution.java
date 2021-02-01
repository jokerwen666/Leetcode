package linkedList.leetcode234;

import linkedList.ListNode;

import java.util.Stack;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.30 21:16
 */
public class Solution {
    public boolean isPalindrome3(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while(p != null){
            if(p.val != stack.pop()) return false;
            p = p.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode p1 = head;
        ListNode p2 = null;
        int N = 0;
        while (p1 != null) {
            N++;
            p1 = p1.next;
        }

        //偶数长度，flag=0；奇数长度，flag=1
        int flag = N%2 == 0 ? 0 : 1;

        N = N/2 - 1;
        p1 = head;
        for (int i = 0; i < N; i++)
            p1 = p1.next;

        //偶数长度，p2指向p1的下一个；奇数长度，p2指向p1的下下一个
        p2 = flag == 0 ? p1.next : p1.next.next;

        //将原有链表一分为二，p1指向前半部分，p2指向后半部分
        p1.next = null;
        p1 = head;

        //翻转前半部分
        p1 = reverse(p1);

        //逐个比较
        while (p1 != null){
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    //使用快慢指针快速找到中间位置，慢指针走一步，快指针走两步
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverse(slow.next);
        while (newHead != null){
            if(head.val != newHead.val) return false;
            head = head.next;;
            newHead = newHead.next;
        }

        return true;
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
