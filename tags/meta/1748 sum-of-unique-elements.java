/*
https://leetcode.com/problems/sum-of-unique-elements/

用map存出现的次数，扫描数字，如果没遇到，计入结果并在map标记出现次数为1
如果遇到过，看要不要从结果中减掉，如果此时标记的次数是1，说明没减过，那么从结果中减掉并标记其次数为0
这样下次遇到同样的数字，如果标记个数是0就不用重复减掉了
这样只需要顺序扫描一次结果即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (m.containsKey(num)) {
                if (m.get(num) != 0) {
                    m.put(num, 0);
                    res -= num;
                } 
            } else {
                res += num;
                m.put(num, 1);
            }
        }
        return res;
    }
}