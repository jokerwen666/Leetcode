package linkedList.offer22;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 21:31
 */
public class Solution {

    //获取链表中倒数第k个结点，使用双指针，快指针先走k-1步
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;

        for(int i = 0; i < k; i++)
            former = former.next;

        while(former != null){
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }
}
