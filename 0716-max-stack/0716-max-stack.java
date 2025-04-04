/*
class MaxStack {
    TreeSet<int[]> st;
    TreeSet<int[]> value;
    int cnt = 0;
    public MaxStack() {
        st = new TreeSet<>((a, b) -> a[0] - b[0]);
        value = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
    }
    
    public void push(int x) {
        st.add(new int[]{cnt, x});
        value.add(new int[]{x, cnt});
        cnt++;
    }
    
    public int pop() {
        int[] p = st.pollLast();
        value.remove(new int[]{p[1], p[0]});
        return p[1];
    }
    
    public int top() {
        return st.last()[1];
    }
    
    public int peekMax() {
        return value.last()[0];
    }
    
    public int popMax() {
        int[] p = value.pollLast();
        st.remove(new int[]{p[1], p[0]});
        return p[0];
    }
}
*/
class MaxStack {
    private Stack<int[]> stack;
    private Queue<int[]> heap;
    private Set<Integer> removed;
    private int cnt;

    public MaxStack() {
        stack = new Stack<>();
        heap = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
    }

    public void push(int x) {
        stack.add(new int[] { x, cnt });
        heap.add(new int[] { x, cnt });
        cnt++;
    }

    public int pop() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        return stack.peek()[0];
    }

    public int peekMax() {
        while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
        return heap.peek()[0];

    }

    public int popMax() {
        while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
        int[] top = heap.poll();
        removed.add(top[1]);
        return top[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */