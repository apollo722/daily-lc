class Solution {
    static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
        
    public String intToRoman(int num) {
        ArrayDeque<String> q = new ArrayDeque<>();
        int curDigit = 1;
        while (num != 0) {
            int d = num % 10;
            int val = d * curDigit;
            if (map.containsKey(val)) {
                q.addFirst(map.get(val));
            } else if (val < curDigit * 5) {
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < d; i++) {
                    tmp.append(map.get(curDigit));
                }
                q.addFirst(tmp.toString());
            } else {
                StringBuilder tmp = new StringBuilder();
                tmp.append(map.get(curDigit * 5));
                for (int i = 0; i < d - 5; i++) {
                    tmp.append(map.get(curDigit));
                }
                q.addFirst(tmp.toString());
            }
            num /= 10;
            curDigit *= 10;
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            res.append(q.pollFirst());
        }
        return res.toString();
    }
}