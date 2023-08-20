package greedy;

import java.util.HashSet;

public class MergeTripletsToFormTargetTriplet1899 {
  public boolean mergeTriplets(int[][] triplets, 
                               int[] target) {
    HashSet<Integer> matches = new HashSet<>();

    for (int[] triplet : triplets) {
      if (triplet[0] > target[0]
            || triplet[1] > target[1]
            || triplet[2] > target[2]) {
        continue;
      }

      for (int i = 0; i < 3; i++) {
        if (triplet[i] == target[i]) {
          matches.add(i);
        }
      }
    }

    return matches.size() == 3;
  }
}