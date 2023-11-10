/*
https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/

用hashmap会有额外的overhead以及possible collision

用pair list来存储index和值，计算的时候逐个扫描pair list中的非0元素并相乘

Time: O(n), 建立list, O(l1 + l2) for dot product
Space: O(n)
*/

class SparseVector {
    List<int[]> p = new ArrayList<>();
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                p.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0, res = 0;
        while (i < this.p.size() && j < vec.p.size()) {
            if (this.p.get(i)[0] == vec.p.get(j)[0]) {
                res += this.p.get(i++)[1] * vec.p.get(j++)[1];
            } else if (this.p.get(i)[0] > vec.p.get(j)[0]) j++;
            else i++;
        }
        return res;
    }
}