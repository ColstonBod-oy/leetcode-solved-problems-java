package binarysearch;

public class BinarySearch704 {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int m = (l + r) / 2;
      
      if (nums[m] > target) {
        r = --m; 
      }

      else if (nums[m] < target) {
        l = ++m;
      }

      else {
        return m;
      }
    }

    return -1;
  }
}