/*
给定一个正整数n，返回数组[1, 2, ..., n]的一个排列，使得对于所有的i < j，都不存在k使得i < k < j且nums[k] * 2 = nums[i] + nums[j]。
*/

class LengthNo3ArithmeticProgression {
    public int[] find(int n) {
        int x = 1;
        while (x < n) x *= 2;
        int[] resX = solve(x);
        int[] res = new int[n];
        int i = 0;
        for (int num : resX) {
            if (num <= n) res[i++] = num;
        }
        return res;
    }

    private int[] solve(int n) {
        if (n == 1) return new int[]{1};
        if (n == 2) return new int[]{1, 2};
        int[] resX = solve(n / 2);
        int[] res = new int[n];
        for (int i = 0; i < resX.length; i++) {
            res[i] = resX[i] * 2;
            res[i + n / 2] = resX[i] * 2 - 1;
        }
        return res;
    }
    public static void main(String[] args) {
        LengthNo3ArithmeticProgression solution = new LengthNo3ArithmeticProgression();
        int[] res = solution.find(15);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}

/*
对于任意两个整数，他们的均值如果是整数，那么他们一定同奇或同偶。
所以一种想法是把n个数分成两部分，前一半都是偶数，后一半都是奇数。
之后从小开始迭代，每次翻倍。
每次翻倍的时候，前一半的数翻倍，后一半的数翻倍减一。
这样如果两个数分别是奇数和偶数，那么他们的均值非整数，不在数组中。
如果两个数都在子前半段，那么他们的均值要么在外面，要么是个非整数。后半段同理。
*/
