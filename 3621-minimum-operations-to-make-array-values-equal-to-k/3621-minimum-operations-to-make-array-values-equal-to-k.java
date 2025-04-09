class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            set.add(num);
        }
        return set.contains(k) ? set.size() - 1 : set.size();
    }
}