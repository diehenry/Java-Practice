package leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergeNum = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergeNum[k++] = nums1[i++];
            } else {
                mergeNum[k++] = nums2[j++];
            }
        }
        while (i < m) {
            mergeNum[k++] = nums1[i++];
        }
        while (j < n) {
            mergeNum[k++] = nums2[j++];
        }

        int total = m + n;
        double median;
        if (total % 2 == 0) {
           median = (mergeNum[total / 2 - 1] + mergeNum[total / 2]) / 2.0;
        } else {
           median = mergeNum[total / 2];
        }

        return median;
    }
}
