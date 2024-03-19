/*
https://leetcode.com/problems/split-message-based-on-limit/

问题的关键是怎么样才能提前知道最少需要多少段，或者说要知道分母的量级
每次需要变化的时候即1-9，10-99，100-999以此类推
所以可以分段计算需要的额外字符的长度
比如如果最后的量级是1-9，每行结尾固定需要</>，即3个字符，算上分子分母各1，再乘上9行，也就是打满9行需要45个字符
如果每一行的limit*9-45>=message.length()的话就可以在9这个量级装下所有信息，那么分母就固定了
如果9不行，那就要考虑10-99，这90段会消耗3+2+2=7个固定字符，1-9之间要消耗3+1+2=6个字符，这里分母还是两位，分子是一位
所以依次计算看分母是哪个量级，计算出来之后分母的长度就会作用在每一行上
剩下的就是字符串拼接了

Time: O(n)
Space: O(n)
*/

class Solution {
    public String[] splitMessage(String message, int limit) {
        int total = message.length();
        int len = 1, part = 9;
        while (true) {
            int cost = 0, digitCnt = 9;
            for (int i = 1; i <= len; i++, digitCnt *= 10) {
                int fixCost = len + 3;
                cost += (fixCost + i) * digitCnt;
            }
            if (limit * part - cost >= total) break;
            len++;
            part = part * 10 + 9;
        }
        if (limit <= len * 2 + 3) return new String[0];
        int curPart = 1, idx = 0;
        List<String> resList = new ArrayList<>();
        while (total > 0) {
            StringBuilder sb = new StringBuilder();
            int curTake = limit - (len + (curPart + "").length() + 3);
            sb.append(message.substring(idx, Math.min(idx + curTake, message.length())));
            idx += curTake;
            total -= curTake;
            sb.append("<" + curPart + "/");
            resList.add(sb.toString());
            curPart++;
        }
        String[] res = new String[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i) + (curPart - 1) + ">";
        }
        return res;
    }
}