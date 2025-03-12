class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        
        int l = 0;
        int r = nums.size() - k;
        
        while (l < r) {
            int mid = (l + r) / 2;
            if (Math.abs(target - nums.get(mid + k)) < Math.abs(target - nums.get(mid))) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return nums.subList(l, l + k);
    }
    
    public void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}