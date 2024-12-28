/*
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

O(n)找到最大的两个数即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2){
                max2 = num;
            }
        }
        
        return (max1 - 1) * (max2 - 1);
    }
}