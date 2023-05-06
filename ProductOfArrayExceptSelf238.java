class ProductOfArrayExceptSelf238 {
  public int[] productExceptSelf(int[] nums) {
    int[] products = new int[nums.length];
    products[0] = 1;
      
    int multiplier = 1;
    int index = 0;

    for (; index < nums.length - 1; index++) {
      multiplier = products[index + 1] 
                 = multiplier * nums[index];
    }

    multiplier = 1;
      
    for (--index; index >= 0; index--) {
      multiplier *= nums[index + 1];
      products[index] *= multiplier;
    }

    return products;
  }
}