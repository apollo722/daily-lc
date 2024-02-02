/*
https://leetcode.com/problems/sequential-digits/

有许多种做法
首先满足条件的数字一定属于"123456789"中的某一段
而长度一定属于[len(low),len(high)]
所以遍历所有可能的长度，从模板str中逐个检查每一段substr形成的数字是否在范围内即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String map = "123456789";
        int n = 10;
        List<Integer> res = new ArrayList<>();
        int lowLen = String.valueOf(low).length(), highLen = String.valueOf(high).length();
        for (int i = lowLen; i <= highLen; i++) {
            for (int j = 0; j < n - i; j++) {
                int num = Integer.parseInt(map.substring(j, j + i));
                if (num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}