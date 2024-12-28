/*
https://leetcode.com/problems/flatten-nested-list-iterator/

用一个stack来装输入的iterator
每次hasNext() call的时候，来找到下一个整数
先看现在的栈顶还有没有下一个了，如果没了，pop找下一个
如果有的话，下一个就是栈顶的next()，有可能是list有可能是int
如果是int，就set到peek位，并返回
否则就把这个list本身的iterator放到栈顶

Time: O(l/n)，l为nested list中list的总数，n为nested list中int的总数，d为最大深度
Space: O(d)
*/

public class NestedIterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> st = new ArrayDeque();
    private Integer peek = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        st.addFirst(nestedList.iterator());
    }

    private void setPeek() {
        if (peek != null) return;     
        while (!st.isEmpty()) {
            if (!st.peekFirst().hasNext()) {
                st.pollFirst();
                continue;
            }
            NestedInteger next = st.peekFirst().next();
            if (next.isInteger()) {
                peek = next.getInteger();
                return;
            }
            st.addFirst(next.getList().iterator());
        }        
    }
    
    @Override
    public Integer next() {       
        Integer result = peek;
        peek = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        setPeek();
        return peek != null;
    }
}