/*
https://leetcode.com/problems/logger-rate-limiter/

用map存储message和timestamp的关系
新message到来时，如果message没有出现过，或者出现过但是timestamp和此刻间隔大于等于10
则更新timestamp且返回true
否则返回false

Time: O(1)
Space: O(n)
*/

class Logger {
    HashMap<String, Integer> m;

    public Logger() {
        m = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!m.containsKey(message) || timestamp - m.get(message) >= 10) {
            m.put(message, timestamp);
            return true;
        } 
        return false;
    }
}