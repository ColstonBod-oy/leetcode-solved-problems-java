package graphs;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class CourseSchedule207 {
  HashMap<Integer, List<Integer>> map = new HashMap<>();
  HashSet<Integer> visited = new HashSet<>();
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    for (int i = 0; i < numCourses; i++) {
      map.computeIfAbsent(i, 
        k -> new ArrayList<>()
      );
    }

    for (int[] prereq : prerequisites) {
      map.get(prereq[0]).add(prereq[1]);
    }

    for (int[] prereq : prerequisites) {
      if (!canFinish(prereq[0])) return false;
    }

    return true;
  }

  public boolean canFinish(int course) {
    if (visited.contains(course)) return false;
    if (map.get(course).isEmpty()) return true;

    visited.add(course);

    for (int prereq : map.get(course)) {
      if (!canFinish(prereq)) return false;
    }

    visited.remove(course);
    map.put(course, new ArrayList<>());
    return true;
  }
}