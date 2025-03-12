/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int r = rand7(), c = rand7();
            int res = (r - 1) * 7 + c;
            if (res > 40) continue;
            return (res % 10) + 1;
        }
    }
}