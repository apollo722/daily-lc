/*
https://leetcode.com/problems/encode-and-decode-tinyurl/

有很多种方式可以map原来的url到缩小版url
可以用简单的random number或者counter
也可以用某种hash func
最简单的也可以像下面code一样生成固定长度的str

Time: O(1)
Space: O(n)
*/

public class Codec {
    Map<String, String> m = new HashMap<>();
    String mapStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    String prefix = "http://tinyurl.com/";
    int len = 6;

    public String encode(String longUrl) {
        String res = getSuffix();
        while (m.containsKey(res)) res = getSuffix();
        m.put(res, longUrl);
        return prefix + res;
    }

    public String getSuffix() {
        StringBuilder sb = new StringBuilder();
        int n = mapStr.length();
        for (int i = 0; i < len; i++) {
            sb.append(mapStr.charAt(rand.nextInt(n)));
        }
        return sb.toString();
    }

    public String decode(String shortUrl) {
        return m.get(shortUrl.substring(prefix.length()));
    }
}