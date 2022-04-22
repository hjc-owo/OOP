//MyStack.java

import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> values = new LinkedList<T>();

    public void push(T t) {
        //Your code here
        values.add(t);
    }

    public T pull() {
        //Your code here
        T t = values.getLast();
        values.removeLast();
        return t;
    }

    public T peek() {
        return values.getLast();
        //Your code here
    }

    public static void main(String[] args) {
        /* Your test code here */
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
    }
}

