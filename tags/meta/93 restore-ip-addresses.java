/*
https://leetcode.com/problems/restore-ip-addresses/

标准backtracking

Time: O(m^n n), n为总共可以被分成多少个整数，m为每个整数最多有多少位数
Space: O(mn)
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, String s, List<String> list, List<String> res) {
        if (idx == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String num : list) {
                sb.append(num);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        
        if ((4 - list.size()) * 3 < s.length() - idx || 4 - list.size() > s.length() - idx) return;
        if (!Character.isDigit(s.charAt(idx))) return;
        for (int i = idx + 1; i <= idx + 3 && i <= s.length(); i++) {
            if (i < s.length() && !Character.isDigit(s.charAt(i))) return;
            String cur = s.substring(idx, i);
            if (cur.equals("0")) {
                list.add(cur);
                backtrack(i, s, list, res);
                list.remove(list.size() - 1);
                break;
            } else {
                int curV = Integer.valueOf(cur);
                if (curV >= 1 && curV <= 255) {
                    list.add(cur);
                    backtrack(i, s, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}