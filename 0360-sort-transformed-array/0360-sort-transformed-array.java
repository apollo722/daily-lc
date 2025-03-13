class Solution {
    private int transform(int x, int a, int b, int c) {
        return (a * x * x) + (b * x) + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] answer = new int[n];
        double symmetryAxis = -b / (2.0 * a); // 计算对称轴

        // 找到对称轴在数组中的位置
        int splitIndex = findSplitIndex(nums, symmetryAxis);

        int left = splitIndex - 1;
        int right = splitIndex;
        int index = 0;

        if (a >= 0) {
            // 开口向上，从对称轴向两侧合并，先取较小的值
            while (left >= 0 && right < n) {
                int leftVal = transform(nums[left], a, b, c);
                int rightVal = transform(nums[right], a, b, c);
                if (leftVal < rightVal) {
                    answer[index++] = leftVal;
                    left--;
                } else {
                    answer[index++] = rightVal;
                    right++;
                }
            }
            // 处理剩余的元素
            while (left >= 0) {
                answer[index++] = transform(nums[left--], a, b, c);
            }
            while (right < n) {
                answer[index++] = transform(nums[right++], a, b, c);
            }
        } else {
            // 开口向下，从对称轴向两侧合并，先取较大的值
            while (left >= 0 && right < n) {
                int leftVal = transform(nums[left], a, b, c);
                int rightVal = transform(nums[right], a, b, c);
                if (leftVal > rightVal) {
                    answer[index++] = leftVal;
                    left--;
                } else {
                    answer[index++] = rightVal;
                    right++;
                }
            }
            // 处理剩余的元素
            while (left >= 0) {
                answer[index++] = transform(nums[left--], a, b, c);
            }
            while (right < n) {
                answer[index++] = transform(nums[right++], a, b, c);
            }
            // 如果开口向下，结果需要反转
            reverseArray(answer);
        }

        return answer;
    }

    // 找到对称轴在数组中的位置
    private int findSplitIndex(int[] nums, double symmetryAxis) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < symmetryAxis) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 反转数组
    private void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}