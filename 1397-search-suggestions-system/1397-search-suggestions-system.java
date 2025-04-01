class Solution {
    int l, r;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        this.l = 0;
        this.r = products.length - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(get(products, i, searchWord.charAt(i)));
        }
        return res;
    }

    private List<String> get(String[] products, int idx, char c) {
        if (l > r) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int n = products.length;
        while (l < n && (idx >= products[l].length() || products[l].charAt(idx) != c)) l++;
        while (r >= 0 && (idx >= products[r].length() || products[r].charAt(idx) != c)) r--;
        for (int i = l; i <= r; i++) {
            res.add(products[i]);
            if (res.size() == 3) break;
        }
        return res;
    }
}