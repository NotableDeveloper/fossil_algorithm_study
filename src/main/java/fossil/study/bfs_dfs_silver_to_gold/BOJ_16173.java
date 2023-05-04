package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_16173 {
    final static String GOOD = "HaruHaru";
    final static String BAD = "Hing";
    static int[][] graph;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int targetY;
    static int targetX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][];
        targetY = n - 1;
        targetX = n- 1;
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solution());
    }

    private static String solution() {
        return bfs(0, 0) ? GOOD : BAD;
    }
/**
 * 메모리 초과
    private static boolean dfs(int startY, int startX) {
        if (startY == targetY && startX == targetX) {
            return true;
        }
        for (int i = 0; i < dx.length; i++) {
                int nextY = startY + graph[startY][startX] * dy[i];
                int nextX = startX + graph[startY][startX] * dx[i];
                if(nextY > targetY || nextX > targetX){
                    continue;
                }else if (dfs(nextY, nextX)) {
                    return true;
                }

        }
        return false;
    }
 **/
    private static boolean bfs(int startY, int startX){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY,startX});
        boolean[][] visited = new boolean[targetY+1][targetX+1];
        boolean isGoal = false;
        visited[startY][startX] = true;
        while(!queue.isEmpty()){
            int currY = queue.peek()[0];
            int currX = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextY = currY + graph[currY][currX] * dy[i];
                int nextX = currX + graph[currY][currX] * dx[i];
                if(nextY > targetY || nextX > targetX){
                    continue;
                }
                if(visited[nextY][nextX]){
                    continue;
                }
                if(nextY == targetY && nextX == targetX){
                    isGoal = true;
                    return isGoal;
                }
                queue.add(new int[]{nextY,nextX});
                visited[nextY][nextX] = true;
            }
        }
        return isGoal;
    }
}
