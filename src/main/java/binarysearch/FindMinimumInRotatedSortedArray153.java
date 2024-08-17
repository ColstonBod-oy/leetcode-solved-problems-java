package binarysearch;

public class FindMinimumInRotatedSortedArray153 {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int res = nums[0];

    while (l <= r) {
      if (nums[l] <= nums[r]) {
        res = Math.min(res, nums[l]);
        break;
      }

      int m = (l + r) / 2;
      res = Math.min(res, nums[m]);

      if (nums[m] >= nums[l]) {
        l = ++m;
      }

      else {
        r = m;
      }
    }

    return res;
  }
}