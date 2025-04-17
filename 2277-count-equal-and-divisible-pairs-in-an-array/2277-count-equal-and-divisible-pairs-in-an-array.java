class Solution {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                for (int idx : map.get(num)) {
                    if (idx * i % k == 0) {
                        res++;
                    }
                }
            }
            if (!map.containsKey(num)) map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }
        return res;
    }
}