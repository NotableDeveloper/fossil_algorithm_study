package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13565 {
    static boolean check = false;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new char[firstLine[0]][];
        visited = new boolean[firstLine[0]][firstLine[1]];
        for (int i = 0; i < firstLine[0]; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int x = 0; x < graph[0].length; x++) {
            if (!visited[0][x]) {
                dfs(0, x);
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int startY, int startX) {
        visited[startY][startX] = true;
        if (startY == graph.length - 1) {
            check = true;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if (!inRange(nextY, nextX)) {
                continue;
            }
            if (check) {
                return;
            }
            if (graph[nextY][nextX] == '0' && !visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }
        return;
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < graph.length && 0 <= x && x < graph[0].length;
    }
}
