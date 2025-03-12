class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (n == 0) return true;
            if (flowerbed[i] == 1) continue;
            boolean front = i > 0 ? flowerbed[i - 1] == 0 : true;
            boolean end = i < len - 1 ? flowerbed[i + 1] == 0 : true;
            if (front && end) {
                flowerbed[i] = 1;
                n--;
                i++;
            }
        }
        return n <= 0;
    }
}