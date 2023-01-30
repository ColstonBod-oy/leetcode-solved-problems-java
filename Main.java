class Main {
  public static void main(String[] args) {
    // System.out.println(new ClassName().solutionMethod());
    int[] input = {1,3,-1,-3,5,3,6,7};
    System.out.println(new SlidingWindowMaximum239().maxSlidingWindow(input, 3));
  }
}