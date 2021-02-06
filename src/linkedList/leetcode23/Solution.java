package linkedList.leetcode23;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.01 21:57
 */
public class Solution {
    //最朴素的做法，两两合并，时间复杂度O(n^2)
    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }

    //递归
    public ListNode mergeKLists2(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int mark = -1;
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                mark = i;
            }
        }
        if(mark == -1) return null;
        ListNode node = lists[mark];
        lists[mark] = lists[mark].next;
        node.next = mergeKLists2(lists);
        return node;
    }

    //分治 merge的作用是合并从lo到hi的几个链表，mergeTwoLists是合并两个有序链表得到新的有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        //数组为空的时候，lo大于hi
        if (lo > hi) return null;
        int mid = (hi - lo)/2 + lo;
        return mergeTwoLists(merge(lists,lo,mid), merge(lists,mid+1,hi));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a == null ? b : a;

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode ptrA = a;
        ListNode ptrB = b;

        while (ptrA != null && ptrB != null) {
            if (ptrA.val < ptrB.val) {
                tail.next = ptrA;
                ptrA = ptrA.next;
            }
            else {
                tail.next = ptrB;
                ptrB = ptrB.next;
            }

            tail = tail.next;
        }

        tail.next = ptrA == null ? ptrB : ptrA;
        return dummyHead.next;
    }
}
