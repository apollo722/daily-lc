/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String guess = words[random.nextInt(words.length)];
            int matches = master.guess(guess);
            if (matches == 6) return;
            List<String> candidates = new ArrayList<>();
            for (String word : words) {
                if (matches == calc(guess, word)) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
    }

    private int calc(String str, String tar) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tar.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}


/*
每次从list中随机选一个，之后猜它。得到的返回如果是6直接结束。
否则要看下一轮怎么根据结果猜。没有什么好的办法，唯一的信息就是直到这个和结果有多少个字符匹配。
那和它没有这么多匹配的肯定不可能是结果。
所以就可以筛选一轮，把跟它不匹配结果那么多的字符都排除掉。之后再重复。
*/