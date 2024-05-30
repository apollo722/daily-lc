/*
https://leetcode.com/problems/find-the-k-th-lucky-number/

因为只有4和7，很自然的联想到分别代表0和1

找规律
1   1       4   0
2   10      7   1
3   11      44  10
4   110     47  01
5   101     74  10
6   110     77  11
7   111     444 000
8   1000    474 001
9   1001    477 011

发现第k个数字的二进制表达，去掉最高位，就是第k-1个lucky number把0换成4，1换成7

Time: O(logk)，第k个数字有log(k+1)位数
Space: O(logk)
*/

class Solution {
    public String kthLuckyNumber(int k) {
        char[] arr = Integer.toBinaryString(k + 1).substring(1).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') arr[i] = '4';
            else arr[i] = '7';
        }
        return new String(arr);
    }
}