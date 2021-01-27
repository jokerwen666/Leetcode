package linkedList.offer22;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 21:31
 */
public class Solution {

    //获取链表中倒数第k个结点，使用双指针，先让一个
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode top = head;
        ListNode last = head;

        for(int i = 0; i < k-1; i++)
            last = last.next;

        while(last.next != null){
            top = top.next;
            last = last.next;
        }

        return top;
    }
}
