package graphs;

import java.util.List;
import java.util.ArrayList;

public class CourseScheduleII210 {
  List<List<Integer>> adjList = new ArrayList<>();

  public boolean findOrder(int[] index, int[] res,
      int[] visited, int[] finished, int course) {
    if (visited[course] == 1) {
      return false;
    }

    if (finished[course] == 1) {
      return true;
    }

    visited[course] = 1;

    for (int prereq : adjList.get(course)) {
      if (!findOrder(index, res, visited, 
                     finished, prereq)) {
        return false;  
      }
    }

    visited[course] = 0;
    finished[course] = 1;
    res[index[0]++] = course;
    return true;
  }

  public int[] findOrder(int numCourses, 
                         int[][] prerequisites) {
    int[] index = {0};
    int[] res = new int[numCourses];
    int[] visited = new int[numCourses];
    int[] finished = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] prereq : prerequisites) {
      adjList.get(prereq[0]).add(prereq[1]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (!findOrder(index, res, visited, 
                     finished, i)) {
        return new int[] {};
      }
    }

    return res;
  }
}