package linkedlist;

public class FindTheDuplicateNumber287 {
  public int findDuplicate(int[] nums) {
    int tortoise = 0;
    int hare = 0;

    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    }

    while (tortoise != hare);

    int tortoise2 = 0;

    do {
      tortoise = nums[tortoise];
      tortoise2 = nums[tortoise2];
    }

    while (tortoise != tortoise2);

    return tortoise2;
  }
}