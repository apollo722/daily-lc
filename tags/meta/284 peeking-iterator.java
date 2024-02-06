/*
https://leetcode.com/problems/peeking-iterator/

用一个变量或者数据结构存储next到peek即可

Time: O(1)
Space: O(1)
*/

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekValue;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
	}
	
	public Integer peek() {
        if (peekValue != null) return peekValue;
        peekValue = iterator.next();
        return peekValue;
	}
	
	@Override
	public Integer next() {
	    if (peekValue == null) return iterator.next();
        int res = peekValue;
        peekValue = null;
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return peekValue != null || iterator.hasNext();
	}
}