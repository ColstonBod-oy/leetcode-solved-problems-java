class NumberOfStepsToReduceANumberToZero1342 {
  int counter;
    
  public int numberOfSteps(int num) {
    while (num > 0) {
      if (num % 2 == 0) {
        num /= 2;
        counter++;
      }

      else {
        num--;
        counter++;
      }
    }

    return counter;
  }
}