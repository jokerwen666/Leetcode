package linkedList.leetcode20;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Stack
 * @date 2021.01.27 20:07
 */
public class Stack {
    private Node top;
    private class Node{
        char ch;
        Node next;
    }

    public Stack() {
        top = null;
    }

    public void push(char ch){
        Node oldTop = top;
        top = new Node();
        top.ch = ch;
        top.next = oldTop;
    }

    public void pop(){
        top = top.next;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public boolean isPair(char ch){
        //如果栈为空，返回false
        if (isEmpty()) return false;

        if (ch == ')'){
            return top.ch == '(';
        }

        else if (ch == '}'){
            return top.ch == '{';
        }

        else if (ch == ']'){
            return top.ch == '[';
        }

        //其他情况返回false
        else return false;
    }
}
