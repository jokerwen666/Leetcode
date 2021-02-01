package linkedList.Leetcode707;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName MyLinkedList
 * @date 2021.01.31 21:23
 */

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode prev, ListNode next) {this.val = val; this.next = next; this.prev = prev;}
}

public class MyLinkedList {

    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //index超出长度，返回-1
        if (index >= size) return -1;

        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index = index - 1;
        }
        //index没有超出长度，返回对应节点值
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (size == 0) {
            head = new ListNode(val,null, null);
            tail = head;
            size++;
            return;
        }

        ListNode oldHead = head;
        head = new ListNode(val,null, oldHead);
        oldHead.prev = head;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            tail = new ListNode(val,null, null);
            head = tail;
            size++;
            return;
        }

        ListNode oldTail = tail;
        tail = new ListNode(val, tail, null);
        oldTail.next = tail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //index等于链表长度，在某尾插入
        if (index == size) {
            addAtTail(val);
            return;
        }

        //index小于等于0，在链表头插入
        if (index <= 0) {
            addAtHead(val);
            return;
        }

        //index大于size，不插入
        if (index > size)
            return;

        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index = index - 1;
        }

        ListNode node = new ListNode(val, cur.prev, cur);
        ListNode temp = cur.prev;
        cur.prev = node;
        temp.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //index越界不处理
        if (index >= size)
            return;

        //只有一个结点，将head和tail同时指向null
        if (size == 1) {
            size = 0;
            head = null;
            tail = null;
            return;
        }

        //删除第一个结点
        if (index == 0) {
            assert head != null;
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        //删除最后一个结点
        if (index == size - 1) {
            assert tail != null;
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index = index - 1;
        }

        assert cur.prev != null;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.next = null;
        cur.prev = null;
        size--;
    }

}