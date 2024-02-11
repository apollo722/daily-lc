/*
https://leetcode.com/problems/apply-discount-every-n-orders/

按照要求做即可，没有特别之处

Time: O(n)
Space: O(n)
*/

class Cashier {
    Map<Integer, Integer> m = new HashMap<>();
    int cnt, n;
    double factor;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        for (int i = 0; i < products.length; i++) m.put(products[i], prices[i]);
        this.cnt = 0;
        this.n = n;
        this.factor = 1 - discount * 1.0 / 100;
    }
    
    public double getBill(int[] product, int[] amount) {
        cnt++;
        double res = 0;
        for (int i = 0; i < amount.length; i++) {
            res += amount[i] * m.get(product[i]);
        }
        if (cnt % n == 0) {
            cnt = 0;
            res *= factor;
        }
        return res;
    }
}