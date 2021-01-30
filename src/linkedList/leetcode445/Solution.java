package linkedList.leetcode445;

import java.util.Stack;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.29 22:32
 */
public class Solution {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) return l2;
        if (l2 == null || l2.val == 0) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        int sum = 0;
        int carry = 0;

        //先构造一个伪造的头指针，为了便于之后插入结点
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;

        while (l1 != null || l2 != null || carry != 0) {
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            pre.next = new ListNode(sum);
            pre = pre.next;
            sum = 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return reverse(dummyHead.next);
    }


    //如果不用翻转链表的话，可以用栈来保存链表，栈是LIFO的因此可以倒序处理链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) return l2;
        if (l2 == null || l2.val == 0) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode head = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            sum += carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            //如果需要倒序创建链表时，可以使用头插法
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
            sum = 0;
        }

        return head;

    }

    //链表翻转（leetcode206）
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
