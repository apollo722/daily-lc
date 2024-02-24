/*
https://leetcode.com/problems/encode-and-decode-strings/

用特殊字符分开每个str的长度和内容即可
解码时每遇到一个特殊字符，它前面的数字就是后面跟的字符串的长度，逐个解码即可

Time: O(n)
Space: O(n)
*/

public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len + "#" + s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        while (l < s.length()) {
            char c = s.charAt(r);
            if (c == '#') {
                int len = Integer.valueOf(s.substring(l, r));
                res.add(s.substring(r + 1, len + r + 1));
                l = r + len + 1;
                r = l + 1;
            } else r++;
        }
        return res;
    }
}