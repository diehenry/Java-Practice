package leetcode;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        // 指向下一個0應放的位置
        int low = 0;
        // 當前檢查位置
        int mid = 0;
        // 指向下一個2應放的位置
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // mid不用動, 是因為換完可能是0或1, 還要再檢查當前mid值
                swap(nums, mid, high--);
            }
        }


        System.out.println("sort finish = " + Arrays.toString(nums));
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
