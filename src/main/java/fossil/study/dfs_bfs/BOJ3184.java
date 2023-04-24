package fossil.study.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184 {
    static int r, c;
    static int sheep = 0, wolf = 0;
    static char[][] map;
    static boolean[][] visit;
    static int[][] movement = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void main(String[] args) throws IOException {
        int[] answer = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for(int x = 0; x < r; x++){
            for(int y = 0; y < c; y++){
                if(!visit[x][y] && (map[x][y] == 'o' || map[x][y] == 'v')){
                    sheep = 0;
                    wolf = 0;

                    DFS(x, y);

                    if(sheep > wolf)
                        answer[0] += sheep;

                    else answer[1] += wolf;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static void DFS(int x, int y){
        int nx = 0, ny = 0;
        visit[x][y] = true;

        if(map[x][y] == 'v') wolf++;
        if(map[x][y] == 'o') sheep++;

        for(int i = 0; i < movement.length; i++) {
            nx = x + movement[i][0];
            ny = y + movement[i][1];


            if (nx < 0 || ny < 0 || nx >= r || ny >= c ||
                    visit[nx][ny] || map[nx][ny] == '#')
                continue;

            visit[nx][ny] = true;
            DFS(nx, ny);
        }
    }
}
