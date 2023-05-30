package twopointers;

public class TwoSumIIInputArrayIsSorted167 {
  public int[] twoSum(int[] numbers, int target) {
    int leftPtr = 0;
    int rightPtr = numbers.length - 1;

    while (true) {
      if (numbers[leftPtr] + numbers[rightPtr] < target) {
        ++leftPtr;
      }

      else if (numbers[leftPtr] + numbers[rightPtr] > target) {
        --rightPtr;
      }

      else {
        break;
      }
    }

    return new int[] {++leftPtr, ++rightPtr};
  }
}