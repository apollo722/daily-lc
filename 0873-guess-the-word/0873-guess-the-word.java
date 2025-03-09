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