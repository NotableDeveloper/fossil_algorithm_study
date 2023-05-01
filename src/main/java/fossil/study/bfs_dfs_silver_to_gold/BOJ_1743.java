package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1743 {
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = firstLine[0], m = firstLine[1], k = firstLine[2];
        graph = new boolean[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 0; i < k; i++) {
            int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int y = point[0], x = point[1];
            graph[y][x] = true;
        }
        System.out.println(solution());
    }
    private static int solution(){
        int max = 0;
        for (int y = 1; y < graph.length; y++) {
            for (int x = 1; x < graph[0].length; x++) {
                if(!visited[y][x] && graph[y][x]) {
                    max = Math.max(max,dfs(y,x));
                }
            }
        }
        return max;
    }
    private static int dfs(int startY,int startX){
        int result = 1;
        visited[startY][startX] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];
            if(isInRange(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX]){
                visited[nextY][nextX] = true;
                result += dfs(nextY,nextX);
            }
        }
        return  result;
    }
    private static boolean isInRange(int y, int x){
        return y>0 && y< graph.length && x>0 && x<graph[0].length;
    }
}
