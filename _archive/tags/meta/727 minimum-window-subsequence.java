/*
https://leetcode.com/problems/minimum-window-subsequence/

用一种two ptr的想法
以s1="abacbcdfeg"，s2="bcde"为例
      0123456789
在s1中逐个找s2的每一个字符，最后找到的位置是8，也就是直到i=8的时候才找到一个完整的s2
第一个位置出现于i=1，那[1,8]是一个包含s2的子串，但它是最短的吗？并不是，因为以i=4为起点还是可以找到s2，即[4,8]
如果先正着找，再反着找，即找到最后一个位置8后，再从8开始反向找s2，最后找到的位置就是当前子串中包含s2的最短串（也许和之前相同）
循环往复这个过程直到所有子串已经都找出来

稍微解释一下下一轮寻找为什么从找到的起点的下一位开始而不是终点的下一位开始
比如abacbcdabecde，第一轮找到bcdabe的时候下一轮要从b后的c开始找，而不是e后的c，是因为bcdabe中也可能包含接下来更短的起点
即becde，如果从e后的c开始找就会miss掉

Time: O(mn)，m为s1长度，n为s2长度
Space: O(n)，Java的substring需要复制本体到新的空间
*/

class Solution {
    public String minWindow(String s1, String s2) {
        char[] arr2 = s2.toCharArray();
        int i = -1, resIdx = 0, resLen = Integer.MAX_VALUE;
        while (true) {
            for (char c : arr2) {
                if ((i = s1.indexOf(c, i + 1)) < 0) {
                    return resLen == Integer.MAX_VALUE ? "" : s1.substring(resIdx, resIdx + resLen);
                }
            }
            int idx = ++i;
            for (int j = arr2.length - 1; j >= 0; j--) {            
                i = s1.lastIndexOf(arr2[j], i - 1);
            }
            if (idx - i < resLen) {
                resLen = idx - i;
                resIdx = i;
            }
        }
    }
}