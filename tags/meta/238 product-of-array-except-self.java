/*
https://leetcode.com/problems/product-of-array-except-self/

费空间的想法，即用两个数组分别存储i两边的累乘，之后再乘到一起
如果利用输出的空间，先从左到右，可以省下存储累乘的空间
之后再利用一个变量计算每一个位置的累乘，从右往左的计算并乘到数组中即可

Time: O(n)
Space: O(1)，不算输出所需的空间
*/

/*
https://leetcode.com/problems/product-of-array-except-self/

费空间的想法，即用两个数组分别存储i两边的累乘，之后再乘到一起
如果利用输出的空间，先从左到右计算左边的累乘，即可以省下存储累乘的空间
之后再利用一个变量计算每一个位置的累乘，从右往左的计算并乘到数组中即可
再优化一下写法，即利用两个变量分别计算出从左到右以及从右到左每一个位置的累乘
再在每一个位置计算前，将结果计入到结果数组中

Time: O(n)
Space: O(1)，不算输出所需的空间
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int leftProd = 1, rightProd = 1;
        for (int i = 0; i < n; i++) {
            res[i] = leftProd;
            leftProd *= nums[i];
        }
        int cur = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProd;
            rightProd *= nums[i];
        }
        return res;
    }
}