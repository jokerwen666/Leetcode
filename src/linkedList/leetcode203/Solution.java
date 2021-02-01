package linkedList.leetcode203;

import linkedList.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.31 15:46
 */
public class Solution {

    //递归解法
    //该递归函数的作用是：处理以head开头的链表，删除与目标值相同的节点
    public ListNode removeElements(ListNode head, int val) {
        //baseCase
        //当前链表为空，不需要处理
        if(head == null) return null;

        //recursiveCase
        //当前节点值与目标值相同，将head指向处理完的后续链表（删除head节点）
        if (head.val == val)
            head = removeElements(head.next, val);
        //当前节点值与目标值不相同，将head.next指向处理完的后续链表（删除head节点）
        else
            head.next = removeElements(head.next, val);
        return head;
    }

    //递归函数简化
    public ListNode removeElements2(ListNode head, int val) {
        //baseCase
        //当前链表为空，不需要处理
        if(head == null) return null;
        //recursiveCase
        head.next = removeElements2(head.next, val);
        return  head.val == val ? head.next : head;
    }

    //不使用递归，插入dummyHead逐个节点操作
    public ListNode removeElements3(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;

        while(head != null) {
            pre.next = head.val == val ? head.next : pre.next;
            pre = head.val == val ? pre : pre.next;
            head = head.next;
        }

        return dummyHead.next;
    }

    //leetcode817
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        for (int x: G) Gset.add(x);

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }


}
