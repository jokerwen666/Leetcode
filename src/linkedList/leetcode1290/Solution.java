package linkedList.leetcode1290;

import linkedList.ListNode;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.02.01 17:46
 */
public class Solution {
    int base = 1;

    public int getDecimalValue(ListNode head) {
        if(head.next == null) {
            base = base<<1;
            return head.val;
        }
        //这里需要注意先调用递归函数再运算乘法，否则base值还是在改变前的值
        int sum = getDecimalValue(head.next) + head.val*base;
        base = base<<1;
        return sum;
    }
}
