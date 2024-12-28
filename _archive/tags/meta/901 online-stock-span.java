/*
https://leetcode.com/problems/online-stock-span/

用一个list记录之前元素span结果，这样每次check前面的元素就可以直接跳过所有小于当前元素的元素，直到碰到第一个大于当前元素的元素

Time: O(1)，amortized，因为每个元素只会跳跃有限次数，如果有的元素跳的多，其他元素就会跳的少
Space: O(n)
*/

class StockSpanner {
    List<Integer> nums = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        nums.add(price);
        int cur = 1;
        int prev = count.size() - cur;
        while (prev >= 0) {
            if (nums.get(prev) <= price) {
                cur += count.get(prev);
                prev = count.size() - cur;
            } else break;
        }
        count.add(cur);
        return cur;
    }
}