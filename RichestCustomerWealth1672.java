class RichestCustomerWealth1672 {
  private int maximum;
    
  public int maximumWealth(int[][] accounts) {
    for (int[] customer : accounts) {
      int currentSum = 0;
        
      for (int bank : customer) {
        currentSum += bank;
      }

      if (currentSum > maximum) {
        maximum = currentSum;
      }
    }

    return maximum;
  }
}