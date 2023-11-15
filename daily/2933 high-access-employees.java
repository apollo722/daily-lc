/*
https://leetcode.com/problems/high-access-employees/

建立map把员工和数据统计起来并排序员工数据
用大小为3的window来看终点和起点之间的duration是否小于60

Time: O(n klogk)，n为有多少个不同员工，k是每个员工平均的数据
Space: O(nk)
*/

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, List<String>> m = new HashMap<>();
        for (List<String> l : access_times) {
            String name = l.get(0);
            String time = l.get(1);
            if (!m.containsKey(name)) m.put(name, new ArrayList<>());
            m.get(name).add(time);
        }
        List<String> res = new ArrayList<>();
        for (String k : m.keySet()) {
            List<String> l = m.get(k);
            if (l.size() < 3) continue;
            Collections.sort(l);
            for (int i = 0; i < l.size(); i++) {
                String curT = l.get(i);
                if (i + 2 >= l.size()) break;
                String nextT = l.get(i + 2);
                int startH = Integer.valueOf(curT.substring(0, 2)), startM = Integer.valueOf(curT.substring(2, 4));
                int endH = Integer.valueOf(nextT.substring(0, 2)), endM = Integer.valueOf(nextT.substring(2, 4));
                if (endH - startH > 1) continue;
                int duration = endH - startH == 1 ? 60 + endM - startM : endM - startM;
                if (duration < 60) {
                    res.add(k);
                    break;
                }
            }
        }
        return res;
    }
}