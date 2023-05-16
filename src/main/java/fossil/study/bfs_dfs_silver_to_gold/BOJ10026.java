package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10026 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new char[size][];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[] result = solution();
        System.out.print(result[0] + " " + result[1]);
    }

    private static int[] solution() {
        int[] result = new int[2];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (visited[y][x]) {
                    continue;
                }
                result[0] += dp(y, x, true);
            }
        }
        visited = new boolean[map.length][map.length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (visited[y][x]) {
                    continue;
                }
                result[1] += dp(y, x, false);
            }
        }
        return result;
    }

    private static int dp(int startY, int startX, boolean canSee) {
        char curColor = map[startY][startX];
        visited[startY][startX] = true;
        if (canSee) {//적록색약이 아님
            for (int i = 0; i < dx.length; i++) {
                int nextY = startY + dy[i];
                int nextX = startX + dx[i];
                if (!inRange(nextY, nextX)) {
                    continue;
                }
                char nextColor = map[nextY][nextX];
                if (nextColor != curColor || visited[nextY][nextX]) {
                    continue;
                } else {
                    visited[nextY][nextX] = true;
                    dp(nextY, nextX, canSee);
                }
            }
        } else {//적록 색약임
            if (curColor == 'R') {
                curColor = 'G';
            }
            for (int i = 0; i < dx.length; i++) {
                int nextY = startY + dy[i];
                int nextX = startX + dx[i];
                if (!inRange(nextY, nextX)) {
                    continue;
                }
                char nextColor = map[nextY][nextX];
                if (nextColor == 'R') {
                    nextColor = 'G';
                }
                if (nextColor != curColor || visited[nextY][nextX]) {
                    continue;
                } else {
                    visited[nextY][nextX] = true;
                    dp(nextY, nextX, canSee);
                }
            }
        }
        return 1;
    }

    static private boolean inRange(int y, int x) {
        return y >= 0 && y < map.length && x >= 0 && x < map.length;
    }
}
