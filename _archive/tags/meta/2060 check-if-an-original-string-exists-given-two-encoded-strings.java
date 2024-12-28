/*
https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

看似复杂起始抽丝剥茧按照步骤一点点求解，思路比较清晰
整体上属于backtracking+memo的范畴
首先要把输入转换成可以可以回溯求解的形态，即把字符和数字都分开，即例如[a, 123, b, c, d, 4]
这样做的目的是可以更容易的知道现在要对比的是什么，相当于预处理
对比的过程中分为几种情况：
首先是退出情况，如果两个输入已经都探索过了，那么就看现在两方有没有数字（数字代表目前可以wildcard match的长度），数字相等即为true，否则false
如果任何一个到了尾部而另一个没有，且到尾部的当前数字是0，证明此时已经没有可以和它匹配的了，即为false
如果一方是数字，要先快进到含有字符的位置，这样才能进行比较
前进的长度取决于当前数字能代表的长度，因为最多不超过连续三个数字，所以只有有限的情况，全部枚举依次继续求解即可
当两方都快进到有字符的时候，即可以进行比较了
此时，如果两方的wildcard数字长度都不为0，要先进行对齐再判断
如果任一方数字为0且另一方不为0，即可以逐个向前进行比对
直到两方都是0的时候，看字符是否相等即可
整个过程需要把当前进行到的位置与wildcard匹配长度进行memo记忆，以避免重复计算

Time: 
Space: 
*/

class Solution {
    HashSet<String> visited = new HashSet<>();
    public boolean possiblyEquals(String s1, String s2) {
        String[] t1 = parse(s1), t2 = parse(s2);
        return dfs(t1, 0, 0, t2, 0, 0);
    }

    private boolean dfs(String[] t1, int i, int len1, String[] t2, int j, int len2) {
        if (i == t1.length && j == t2.length) return len1 == len2;
        if (i == t1.length && len1 == 0) return false;
        if (j == t2.length && len2 == 0) return false;
        String hash = i + "_" + len1 + "_" + j + "_" + len2;
        if (visited.contains(hash)) return false;
        if (i < t1.length && Character.isDigit(t1[i].charAt(0))) {
            Set<Integer> nums = getNum(t1[i]);
            for (int num : nums) {
                if (dfs(t1, i + 1, len1 + num, t2, j, len2)) return true;
            }
            visited.add(hash);
            return false;
        } else if (j < t2.length && Character.isDigit(t2[j].charAt(0))) {
            Set<Integer> nums = getNum(t2[j]);
            for (int num : nums) {
                if (dfs(t1, i, len1, t2, j + 1, len2 + num)) return true;
            }
            visited.add(hash);
            return false;
        }
        if (len1 != 0 && len2 != 0) {
            int min = Math.min(len1, len2);
            return dfs(t1, i, len1 - min, t2, j, len2 - min);
        } else if (len1 == 0 && len2 != 0) {
            return dfs(t1, i + 1, 0, t2, j, len2 - 1);
        } else if (len1 != 0 && len2 == 0) {
            return dfs(t1, i, len1 - 1, t2, j + 1, len2);
        } else {
            visited.add(hash);
            if (!t1[i].equals(t2[j])) return false;
            return dfs(t1, i + 1, 0, t2, j + 1, 0);
        }
    }

    private Set<Integer> getNum(String t) {
        int d = Integer.parseInt(t);
        Set<Integer> set = new HashSet<>();
        if (t.length() == 1) {
            set.add(d);
        } else if (t.length() == 2) {
            int a = d / 10;
            int b = d % 10;
            set.add(a + b);
            set.add(d);
        } else {
            int a = d / 100;
            int b = (d / 10) % 10;
            int c = d % 10;
            set.add(a + b + c);
            set.add(a + b * 10 + c);
            set.add(a * 10 + b + c);
            set.add(d);   
        }
        return set;
    }

    private String[] parse(String s) {
        String[] t = new String[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                t[index++] = s.substring(i, i + 1);
            } else {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                t[index++] = s.substring(i, j);
                i = j - 1;
            }
        }
        String[] result = new String[index];
        System.arraycopy(t, 0, result, 0, index);
        return result;
    }
}