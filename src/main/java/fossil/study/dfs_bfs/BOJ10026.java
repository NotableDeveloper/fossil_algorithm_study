package fossil.study.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
    static int n;
    static int[] X = {0, 0, -1, 1};
    static int[] Y = {-1, 1, 0, 0};
    // 적록색약이 보는 구역
    static int redAndGreen = 0;
    // 적록색약이 아닌 사람이 보는 구역
    static int redOrGreen = 0;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 사람이 보는 경우
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]){
                    DFS(i, j);
                    redOrGreen++;
                }
            }
        }

        // 적록 색약이 보는 그림으로 변경
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }

        // 적록색약이 보는 경우
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]){
                    DFS(i, j);
                    redAndGreen++;
                }
            }
        }

        System.out.println(redOrGreen + " " + redAndGreen);
    }

    public static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + X[i];
            int ny = y + Y[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(!visit[nx][ny] && arr[nx][ny] == arr[x][y]){
                DFS(nx, ny);
            }
        }
    }
}
