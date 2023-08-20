package greedy;

public class MergeTripletsToFormTargetTriplet1899 {
  public boolean mergeTriplets(int[][] triplets, 
                               int[] target) {
    boolean[] matchesIndex = new boolean[3];

    for (int[] triplet : triplets) {
      if (triplet[0] > target[0]
            || triplet[1] > target[1]
            || triplet[2] > target[2]) {
        continue;
      }

      for (int i = 0; i < 3; i++) {
        if (triplet[i] == target[i]) {
          matchesIndex[i] = true;
        }
      }
    }

    return matchesIndex[0] 
           && matchesIndex[1]
           && matchesIndex[2];
  }
}