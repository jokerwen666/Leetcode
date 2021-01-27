package linkedList.leetcode20;

import java.util.Scanner;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.27 20:07
 */
public class Solution {
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            if (stack.isPair(s.charAt(i)))
                stack.pop();
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        boolean flag = isValid(str);
        System.out.print(flag);
    }
}
