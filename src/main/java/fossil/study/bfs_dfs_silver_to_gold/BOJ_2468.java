package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_2468 {
    private static int[][] graph;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            IntStream intStream = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);
            graph[i] = intStream.toArray();
        }
        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int max = 0;

        for (int i = 0; i < 100; i++) {
            int result = 0;
            visited = new boolean[graph.length][graph.length];
            for (int y = 0; y < graph.length; y++) {
                for (int x = 0; x < graph.length; x++) {
                    result += dfs(y, x, i);
                }
            }
            max = Math.max(result, max);
            if(result == 0){
                break;
            }
        }
        return max;
    }

    private static int dfs(int y, int x, int height) {
        int result = 0;

        if (!isInRange(y, x)) {
            return result;
        }
        if (graph[y][x] <= height) {
            return result;
        }
        if (visited[y][x]) {
            return result;
        }

        visited[y][x] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            dfs(nextY, nextX, height);

        }
        result += 1;
        return result;
    }

    private static boolean isInRange(int y, int x) {
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;
    }
}
