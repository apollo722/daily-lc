class Solution {
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        solve(num, 0, 0, 0, target, "");
        return res;
    }

    private void solve(String s, int idx, long curSum, long prev, int target, String cur) {
        if (s.length() == idx && curSum == target) {
            res.add(cur);
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0') return;
            long val = Long.parseLong(s.substring(idx, i + 1));
            if (idx == 0) {
                solve(s, i + 1, val, val, target, cur + val);
            } else {
                solve(s, i + 1, curSum + val, val, target, cur + "+" + val);
                solve(s, i + 1, curSum - val, -val, target, cur + "-" + val);
                solve(s, i + 1, curSum - prev + prev * val, prev * val, target, cur + "*" + val);
            }
        }
    } 
}


/*
递归解决子状态。
每次要取一个数字，之后在后面尝试放各种计算符号。
如果是加减，上一轮的数字可以直接加进结果中。如果是乘，上一轮的数字要扣回来先结合给乘，之后再加回去。
所以要需要有个变量来记录上一轮数字是什么。
三点要注意的是：
1. 只有第一轮数字是直接挂到结果上的，后面什么运算符都不跟，要单独处理；
2. 题目要求不能有leading 0，但可以有单独的0。所以如果本轮处理的长度超过1，并且一开始的起点是0那应该直接返回。
3. 题目能组合的数字可能会很大，如果直接parse需要用long类型。 
*/