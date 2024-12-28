/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

可以用变量来存储学生，因为学生可以移动到队尾，所以相当于可以走来走去
但三明治是固定的，所以要按照三明治的顺序找学生
如果遇到0，此时已经没有0学生了，证明剩下的1学生都吃不到了，被卡住
同理，遇到1返回剩下的0学生
如果遇到0三明治，还有0号学生，那么他就吃到了，0号学生--
反之同理

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0 = 0, count1 = 0;
        for (int num : students) {
            if (num == 0) count0++;
            else count1++;
        }
        int res = 0;
        for (int num : sandwiches) {
            if (num == 0 && count0 == 0) return count1;
            if (num == 1 && count1 == 0) return count0;
            if (num == 0) count0--;
            else count1--;
        }
        return 0;
    }
}