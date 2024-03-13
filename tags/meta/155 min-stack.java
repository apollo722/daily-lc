/*
https://leetcode.com/problems/min-stack/

stack的本质就是个linkedlist
那么如果存到linkedlist中既有本身节点值，又有最小值，即可以用top元素来记录整个stack中的最小值
所以构造特殊数据结构（其实也可以用stack存pair）
每次push都保证top.min是当时stack中的最小值，之后把原来的头节点挂在新节点后面
之后新节点成为头节点
pop的时候只需要后移节点即可
min即找头节点的min项中的值即可

Time: O(1)
Space: O(n)
*/

class MinStack {
    class Node {
        int val;
        int min;
        Node next;
        Node (int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node next = new Node(val, Math.min(val, head.min));
            next.next = head;
            head = next;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}