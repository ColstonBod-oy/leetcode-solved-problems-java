package graphs;

import java.util.List;
import java.util.ArrayList;

public class CourseScheduleII210 {
  List<List<Integer>> adjList = new ArrayList<>();

  public int[] findOrder(int numCourses, 
                         int[][] prerequisites) {
    int[] visited = new int[numCourses];
    int[] res = new int[numCourses];
    int[] index = {0};

    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] prereq : prerequisites) {
      adjList.get(prereq[0]).add(prereq[1]);
    }

    for (int[] prereq : prerequisites) {
      if (!findOrder(res, index, visited, prereq[0])) {
        return new int[] {};
      }
    }

    if (index[0] < numCourses - 1) {
      for (; index[0] < numCourses; index[0]++) {
        res[index[0]] = index[0];
      }
    }

    return res;
  }
  
  public boolean findOrder(int[] res, int[] index,
                           int[] visited, int course) {
    if (visited[course] == 1) {
      return false;
    }

    if (adjList.get(course).isEmpty()) {
      if (index[0] == 0 || res[index[0] - 1] 
          != course) {
        res[index[0]] = course;
      }
      
      return true;
    }

    visited[course] = 1;

    for (int prereq : adjList.get(course)) {
      if (!findOrder(res, index, visited, prereq)) {
        return false;
      } 
    }

    visited[course] = 0;
    adjList.get(course).clear();

    ++index[0];
    res[index[0]] = course;
    
    return true;
  }
}