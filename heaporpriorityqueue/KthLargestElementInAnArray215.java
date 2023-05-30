class KthLargestElementInAnArray215 {
  public int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    return findKthLargest(nums, k, 0, nums.length - 1);
  }

  public int findKthLargest(int[] nums, int k, int l, int r) {
    int p = l;
    
    for (int i = l; i < r; i++) {
      if (nums[i] <= nums[r]) {
        int temp = nums[i];
        nums[i] = nums[p];
        nums[p] = temp;
        ++p;
      }  
    }

    int temp = nums[r];
    nums[r] = nums[p];
    nums[p] = temp;

    if (p < k) return findKthLargest(nums, k, p + 1, r);
    else if (p > k) return findKthLargest(nums, k, l, p - 1);
    else return nums[p];
  }
}