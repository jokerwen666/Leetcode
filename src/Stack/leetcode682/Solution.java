package Stack.leetcode682;

import java.util.Stack;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 21:45
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        String str;

        for (String op : ops) {
            str = op;

            //str=C，从弹出栈顶元素
            switch (str) {
                case "C":
                    stack.pop();
                    break;

                //str=D，将新元素压栈，新元素的值为原栈顶元素值的二倍
                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                //str=+,将之前两元素值相加
                case "+":
                    stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                    break;

                //其余情况，将str转为int压栈
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }

        int result = 0;
        for (Integer integer : stack)
            result += integer;

        return result;
    }

}
