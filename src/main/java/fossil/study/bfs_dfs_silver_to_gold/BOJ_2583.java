package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2583 {
    static boolean[][] graph ;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = firstLine[0], n = firstLine[1], k = firstLine[2];
        graph = new boolean[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            int[] square = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int leftX = square[0];
            int leftY = square[1];
            int rightX = square[2];
            int rightY = square[3];
            for (int y = leftY; y < rightY; y++) {
                for (int x = leftX; x < rightX; x++) {
                    graph[y][x] = true;
                }
            }
        }
        int[] result = solution();
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    private static int[] solution(){
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[0].length; x++) {
                int size = dfs(y,x);
                if(size!=0){
                    result.add(size);
                }
            }
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    private static int dfs(int startY, int startX){
        int result = 1;
        if(startY<0||startY>=graph.length||startX<0||startX>=graph[0].length){
            return 0;
        }
        if(visited[startY][startX]){
            return 0;
        }
        if(graph[startY][startX]){
            return 0;
        }

        visited[startY][startX] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            result += dfs(nextY,nextX);
        }
        return result;
    }

}
