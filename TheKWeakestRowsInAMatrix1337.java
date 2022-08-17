import java.util.Arrays;

class TheKWeakestRowsInAMatrix1337 {
  private int smallest;
  private int smallestIndex; 
  private int[] orderedRows;
    
  public int[] kWeakestRows(int[][] mat, int k) {
    orderedRows = new int[mat.length + k];

    for (int i = 0; i < mat.length; i++) {
      int numOfSoldiers = 0;

      for (int val : mat[i]) {
        if (val != 1) {
          break;
        }
          
        numOfSoldiers++;
      }

      orderedRows[i + k] = numOfSoldiers;
    }

    boolean isOrdered = false;
    boolean isReset = false;
    int insertionPoint = 0;
      
    while (!isOrdered) {
      for (int i = k; i < orderedRows.length; i++) {
        if (orderedRows[i] > 0) {
          if (orderedRows[i] < smallest && !isReset) {
            smallest = orderedRows[i];
            smallestIndex = i - k;
          }

          else if (i == k || isReset) {
            smallest = orderedRows[i];
            smallestIndex = i - k;
            isReset = false;
          }
        }
      }
        
      orderedRows[smallestIndex + k] = -1;
      orderedRows[insertionPoint] = smallestIndex; 
      isReset = true;

      if (insertionPoint == k - 1) {
        isOrdered = true;
      }

      else {
        insertionPoint++;
      }
    }

    return Arrays.copyOfRange(orderedRows, 0, k);
  }
}