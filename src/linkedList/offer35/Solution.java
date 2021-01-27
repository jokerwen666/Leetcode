package linkedList.offer35;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 20:13
 */
public class Solution {

    //时间复杂度O(n^2)
    public Node copyRandomList2(Node head) {
        if(head == null)
            return null;

        Node newHead = new Node(head.val);
        Node p1 = head;
        Node p2 = newHead;
        int N = 1;
        while(p1.next != null){
            //原链表该结点的random指向null
            if(p1.random == null)
                p2.random = null;

            p2.next = new Node(p1.next.val);
            p1 = p1.next;
            p2 = p2.next;
            N++;
        }

        p1 = head;
        p2 = newHead;
        Node temp1 = null;
        Node temp2 = null;
        int k = 0;
        int pos = 0;

        while(p1 != null){
            if(p1.random == null){
                p1 = p1.next;
                p2 = p2.next;
            }

            else{
                int i = 0;
                temp1 = p1.random;
                temp2 = newHead;
                while(temp1 != null) {
                    temp1 = temp1.next;
                    i++;
                }
                pos = N - i;
                for(int j = 0; j < pos; j++)
                    temp2 = temp2.next;
                p2.random = temp2;
                p1 = p1.next;
                p2 = p2.next;

            }
        }

        return newHead;
    }


    //时间复杂度O(n)


}
