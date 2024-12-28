/*
https://leetcode.com/problems/product-of-the-last-k-numbers/

用list存储preProd
每次增加元素时，取上一个元素*=num，如果最后的结果是0，证明如果k超过这个元素，结果一定是0，否则可以用一个新的stream来返回接下来的preProd
每次取后k个元素乘积时，先看目前有多少个元素
如果k超过了目前的元素个数，证明它cover了有0的元素，故直接返回0
如果k恰好是元素个数，返回最后一个元素
否则返回preProd(n-1)/preProd(n-k-1)

Time: O(1)
Space: O(n)
*/

class ProductOfNumbers {
    List<Integer> stream;
    int last;
    public ProductOfNumbers() {
        stream = new ArrayList<>();
        last = 1;
    }
    
    public void add(int num) {
        last *= num;
        if (last == 0) {
            stream = new ArrayList<>();
            last = 1;
        } else stream.add(last);
    }
    
    public int getProduct(int k) {
        int n = stream.size();
        if (n - k < 0) return 0;
        else if (n - k == 0) return stream.get(n - 1);
        return stream.get(n - 1) / stream.get(n - k - 1);
    }
}