class KokoEatingBananas875 {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = 1;

    for (int p : piles) {
      r = Math.max(r, p);
    }

    while (l < r) {
      int k = (l + r) / 2;
      int totalH = 0;
      
      for (int p : piles) {
        totalH += Math.ceil((double) p / k);
      }

      if (totalH <= h) {
        r = k;
      }

      else {
        l = ++k;
      }
    }

    return r;
  }
}