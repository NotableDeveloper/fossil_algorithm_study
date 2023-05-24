package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11123 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstLine = Integer.parseInt(br.readLine());
        for (int i = 0; i < firstLine; i++) {
            int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            char[][] graph = new char[hw[0]][];
            boolean[][] visited = new boolean[hw[0]][hw[1]];
            for (int h = 0; h < hw[0]; h++) {
                graph[h] = br.readLine().toCharArray();
            }
            System.out.println(solution(graph,visited));
        }
    }

    private static int solution(char[][] graph, boolean[][] visited) {
        int result = 0;
        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[0].length; x++) {
                if(!visited[y][x] && graph[y][x]=='#'){
                    dfs(y,x,graph,visited);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int y, int x, char[][] graph, boolean[][] visited) {
        visited[y][x] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(!inRange(nextY,nextX,graph.length,graph[0].length)){
                continue;
            }
            if(!visited[nextY][nextX] && graph[nextY][nextX] == '#'){
                visited[nextY][nextX] = true;
                dfs(nextY,nextX,graph,visited);
            }
        }
    }
    private static boolean inRange(int y,int x, int h, int w){
        return y>=0 && y<h && x>=0 && x<w;
    }
}
