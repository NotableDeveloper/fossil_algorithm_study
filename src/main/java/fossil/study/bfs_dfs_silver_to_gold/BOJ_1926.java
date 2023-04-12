package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1926 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BOJ_1926 boj1926 = new BOJ_1926();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[firstLine[0]][firstLine[1]];
        visited = new boolean[firstLine[0]][firstLine[1]];
        for (int i = 0; i < firstLine[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] solution = boj1926.solution();
        for (int i : solution) {
            System.out.println(i);
        }
    }
    private int[] solution(){
        int answer = 0;
        int cntOfImage = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                int size = dfs(y,x);
                if(size!=0){
                    cntOfImage += 1;
                }
                answer = Math.max(answer,size);
            }
        }
        return new int[]{cntOfImage,answer};

    }

    private int dfs(int startY, int startX) {
        int size=0;
        if(visited[startY][startX]|| map[startY][startX] == 0){
            return 0;
        }
        visited[startY][startX] =  true;
        size += 1;
        for (int i = 0; i < dx.length; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];

            if(nextY<0||nextX<0||nextY>=map.length||nextX>=map[0].length){
                continue;
            }
            if(!visited[nextY][nextX]){
                size += dfs(nextY,nextX);
            }
        }
        return size;
    }
}
