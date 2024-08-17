package graphs;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class CourseSchedule207 {
  HashMap<Integer, List<Integer>> map = new HashMap<>();
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] visited = new int[numCourses];
    
    for (int i = 0; i < numCourses; i++) {
      map.computeIfAbsent(i, 
        k -> new ArrayList<>()
      );
    }

    for (int[] prereq : prerequisites) {
      map.get(prereq[0]).add(prereq[1]);
    }

    for (int[] prereq : prerequisites) {
      if (!canFinish(visited, prereq[0])) return false;
    }

    return true;
  }

  public boolean canFinish(int[] visited, int course) {
    if (visited[course] == 1) return false;
    if (map.get(course).isEmpty()) return true;

    visited[course] = 1;

    for (int prereq : map.get(course)) {
      if (!canFinish(visited, prereq)) return false;
    }

    visited[course] = 0;
    map.put(course, new ArrayList<>());
    return true;
  }
}