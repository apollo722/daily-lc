/*
https://leetcode.com/problems/find-unique-binary-string/

将每个元素换成十进制放到set可以做，复杂度O(n2)，是因为二进制十进制相互转换需要O(n)

进阶算法，从第i个数字取第i位，保证答案的第i位和其不同即可
这样就可以保证每个数字都至少有一位和答案不同

Time: O(n)
Space: O(1)
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            res.append(c == '0' ? '1' : '0');
        }
        return res.toString();
    }
}