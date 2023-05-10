import java.util.PriorityQueue;

class KClosestPointsToOrigin973 {
  public int[][] kClosest(int[][] points, int k) { 
    PriorityQueue<Integer[]> pq = new PriorityQueue<>(
      (a, b) -> a[0].compareTo(b[0])
    );

    for (int[] point : points) {
      int distance = 0;
      
      for (int n : point) {
        distance += Math.pow(n, 2);  
      }

      Integer[] data = {distance, point[0], point[1]};
      pq.offer(data);
    }

    int i = 0;
    int[][] res = new int[k][2];

    while (k > 0) {
      Integer[] data = pq.poll();
      
      for (int j = 0; j < 2; j++) {
        res[i][j] = data[j + 1];
      }

      ++i; --k;
    }

    return res;
  }
}