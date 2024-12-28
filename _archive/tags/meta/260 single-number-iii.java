/*
https://leetcode.com/problems/single-number-iii/

按照原本bit manipulation的做法，如果只有1个元素出现一次，其他元素出现两次
把所有元素异或之后剩下的就是结果
但现在有两个元素只出现一次，那么都异或之后剩下的是两个出现一次元素x与y各bit异同情况
对于位运算，有这样的性质：bitmask & (-bitmask)的结果，是其它位全0，只有最右的1位置是1
那么x与y和新的diff有啥关系呢？
diff里面只有一个1，而x与y其中的一个在那个位置上是0（原本的bitmask上面的1代表x与y在那个位置上不同，所以最后那个1代表x与y在那个位置上，一个是0一个是1）
也就是说，其他所有数字与diff的&运算都不是0，只有x或y中那个位置是0的数字与diff的与运算是0
那么只要把其他所有元素都异或起来，结果就是x与y其中在那个位置上不为0的元素
另一个就是原本bitmask与它的异或

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int num1 = 0;
        for (int num : nums) if ((num & diff) != 0) num1 ^= num;
        return new int[]{num1, bitmask ^ num1}; 
    }
}