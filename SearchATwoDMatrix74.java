class SearchATwoDMatrix74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int t = 0;
    int b = matrix.length - 1;
    int row = (t + b) / 2;
    int col = matrix[0].length - 1;

    while (t <= b) {
      if (target < matrix[row][0]) {
        b = --row; 
      }

      else if (target > matrix[row][col]) {
        t = ++row;
      }

      else {
        break;
      }
    }

    if (t > b) {
      return false;
    }

    int l = 0;
    int r = col;
    
    while (l <= r) {
      int m = (l + r) / 2;

      if (target < matrix[row][m]) {
        r = --m; 
      }

      else if (target > matrix[row][m]) {
        l = ++m;
      }

      else {
        return true;
      }
    }

    return false;
  }
}