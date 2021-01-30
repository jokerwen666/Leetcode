package linkedList.leetcode24;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.30 20:42
 */
public class Solution {
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode p = head;
        ListNode cur = head;
        ListNode pre = null;
        head = head.next;

        while (p != null && p.next != null){
            p = p.next.next;

            if(pre != null)
                pre.next = cur.next;

            pre = cur;
            cur = cur.next;
            cur.next = pre;
            pre.next = p;
            cur = p;
        }

        return head;
    }

    //解决复杂链表问题的时候，可以考虑在头部添加哑结点便于处理
    public ListNode swapPairs(ListNode head) {
        //如果head为空或者链表仅有一个结点，此时直接返回head
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            /*
            循环跳出的条件是临时指针temp结点后面不存在或仅存在一个结点，也就是说我们希望
            temp -> node1 -> node2 转变为：
            temp -> node2 -> node1
             */

            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
