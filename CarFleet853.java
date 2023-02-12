import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.function.Supplier;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toMap;

class CarFleet853 {
  public int carFleet(int target, int[] position, int[] speed) {
    Supplier<TreeMap<Integer, Integer>> mapSupplier = () -> 
      new TreeMap<>(reverseOrder());
    Map<Integer, Integer> velocities = IntStream.range(0, position.length)
      .boxed().collect(toMap(i -> position[i], i -> speed[i],
      (i, j) -> i, mapSupplier));
    Stack<Double> s = new Stack<>();
    
    for (Map.Entry<Integer, Integer> m : velocities.entrySet()) {
      s.push((double) (target - m.getKey()) / m.getValue());
      
      if (s.size() > 1 && s.peek() <= s.get(s.size() - 2)) {
        s.pop();
      }
    }

    return s.size();
  }
}