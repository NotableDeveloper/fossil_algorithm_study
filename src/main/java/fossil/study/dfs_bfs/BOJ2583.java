package fossil.study.dfs_bfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2583 {
    static int m, n, k;
    static int area;
    static ArrayList<Integer> areaSizes = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[m][n];

        for(int i = 0; i < k; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    map[y][x] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0){
                    area = 0;
                    DFS(i, j);
                    areaSizes.add(area);
                }
            }
        }

        Collections.sort(areaSizes);

        System.out.println(areaSizes.size());

        for(int size : areaSizes){
            System.out.print(size + " ");
        }
    }

    private static void DFS(int x, int y) {
        map[x][y] = 1;
        area++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(map[nx][ny] == 0)
                    DFS(nx, ny);
            }
        }
    }
}
