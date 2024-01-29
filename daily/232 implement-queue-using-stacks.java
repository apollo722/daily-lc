/*
https://leetcode.com/problems/implement-queue-using-stacks/

用两个stack来模拟queue
每次pop或者peek都从其中一个stack中取，每次取之前如果它是空的，就把另一个stack的数都转移过来即可

Time: O(1)
Space: O(n)
*/

class MyQueue {
    Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.push(x);    
    }
    
    public int pop() {
        if (!st2.isEmpty()) return st2.pop();
        while (!st1.isEmpty()) st2.push(st1.pop());
        return st2.pop();
    }
    
    public int peek() {
        if (!st2.isEmpty()) return st2.peek();
        while (!st1.isEmpty()) st2.push(st1.pop());
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}