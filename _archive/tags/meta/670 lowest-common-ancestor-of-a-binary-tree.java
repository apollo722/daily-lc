/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

对于输入数字的每一个位置，如果它后面有比它大的数字，那么二者交换位置就能使得结果更大
想要结果越大，就需要原数字越靠前越好，与其交换的数字越大越好，且被交换的数字位置越靠后越好
所以先统计出来每个数字出现的最靠后的位置
之后从第一位开始找，按照从大到小的顺序依次找9~当前数字
如果能找到一个位置比当前数字的位置靠后，交换二者即为答案

Time: O(n)，n为num digit的个数
Space: O(n)，java转化到str arr需要# of num digit的空间
*/

class Solution {
    public int maximumSwap(int num) {
        int[] m = new int[10];
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            m[arr[i] - '0'] = i;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            char c = arr[i];
            for (char l = '9'; l > c; l--) {
                if (m[l - '0'] > i) {
                    arr[i] = l;
                    arr[m[l - '0']] = c;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}