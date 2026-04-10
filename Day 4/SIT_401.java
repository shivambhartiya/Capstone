//Course schedular Order (Simple DAG problem)
//Real: Planning course completion order in a university curriculum
// Given a course (0, n-1) and prerequisites , return a valid order

// Kahn's Algorithm
import java.util.*;

public class SIT_401 {
    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(n, prerequisites)));
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {  
        List<Integer> order = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Build the graph and in-degree array
        for (int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            // Decrease in-degree of neighboring courses
            if (graph.containsKey(course)) {
                for (int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Check if all courses are included in the order
        if (order.size() == numCourses) {
            return order.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0]; // Return empty array if it's not possible to finish all courses
        }
    }
}
