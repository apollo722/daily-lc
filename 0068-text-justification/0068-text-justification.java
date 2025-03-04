class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, cur = 0;
        List<String> res = new ArrayList<>();
        while (cur < n) {
            int curLen = 0, wordCnt = 0, i = cur, wordLen = 0;
            while (cur < n && curLen + words[cur].length() <= maxWidth) {
                wordLen += words[cur].length();
                curLen += words[cur].length();
                wordCnt++;
                cur++;
                if (curLen == maxWidth || cur == n) break;
                curLen++;
            }
            StringBuilder sb = new StringBuilder();
            if (cur == n) {
                while (wordCnt-- > 0) {
                    sb.append(words[i++]);
                    if (wordCnt > 0) sb.append(" ");
                    else {
                        for (int j = 0; j < maxWidth - curLen; j++) sb.append(" ");
                    }
                }
            } else {
                int spaceCnt = wordCnt - 1, spaceLeft = maxWidth - wordLen;
                int nextFill = spaceCnt == 0 ? 0 : (int) Math.ceil(spaceLeft * 1.0 / spaceCnt);
                while (wordCnt-- > 0) {
                    sb.append(words[i++]);
                    for (int j = 0; j < nextFill; j++) sb.append(" ");
                    spaceCnt--;
                    spaceLeft -= nextFill;
                    nextFill = spaceCnt == 0 ? 0 : (int) Math.ceil(spaceLeft * 1.0 / spaceCnt);
                }
                for (int j = 0; j < spaceLeft; j++) sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
}