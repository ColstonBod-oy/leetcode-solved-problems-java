package binarysearch;

public class MedianOfTwoSortedArrays4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;

    if (len2 < len1) {
      return findMedianSortedArrays(nums2, nums1); 
    }

    int half = (len1 + len2 + 1) / 2;
    int l = 0;
    int r = len1;

    while (true) {
      int m = (l + r) / 2;
      int i = half - m;
      int left1 = (m > 0) ? nums1[m - 1] : Integer.MIN_VALUE;
      int right1 = (m < len1) ? nums1[m] : Integer.MAX_VALUE;
      int left2 = (i > 0) ? nums2[i - 1] : Integer.MIN_VALUE;
      int right2 = (i < len2) ? nums2[i] : Integer.MAX_VALUE;

      if (left1 <= right2 && left2 <= right1) {
        if ((len1 + len2) % 2 == 0) {
          return ((double) Math.max(left1, left2) + 
                  Math.min(right1, right2)) / 2;
        }

        return (double) Math.max(left1, left2);
      }

      else if (left1 > right2) {
        r = --m;
      }

      else {
        l = ++m;
      }
    }
  }
}