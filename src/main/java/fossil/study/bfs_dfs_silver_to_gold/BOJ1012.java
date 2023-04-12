package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class BOJ1012 {
    int[] dx = {0, 0, 1,-1};
    int[] dy = {1,-1 ,0, 0};
    int num = 0;
    static boolean[][]  visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BOJ1012 boj1012 = new BOJ1012();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map = new int[firstLine[1]][firstLine[0]];
            visited = new boolean[firstLine[1]][firstLine[0]];
            for (int j = 0; j < firstLine[2]; j++) {
                int[] pointXandY = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[pointXandY[1]][pointXandY[0]] = 1;
            }
            System.out.println(boj1012.solution());

        }
    }
    private int solution(){
        int result = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                result += bfs(y,x);
            }
        }
        return result;
    }
    private int dfs(int startY,int startX){
        if(visited[startY][startX] || map[startY][startX]==0){
            return 0;
        }
        visited[startY][startX] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];
            if(nextY<0||nextY>=map.length||nextX<0||nextX>=map[0].length){
                continue;
            }
            if(!visited[nextY][nextX] && map[nextY][nextX] == 1){
                dfs(nextY,nextX);
            }
        }
        return 1;
    }
    private int bfs(int startY, int startX){
        if(visited[startY][startX] || map[startY][startX] != 1){
            return 0;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY,startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()){
            int curY = queue.peek()[0];
            int curX = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if(nextY<0 || nextY >=map.length|| nextX<0|| nextX >= map[0].length){
                    continue;
                }
                if(!visited[nextY][nextX] && map[nextY][nextX] == 1){
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return 1;
    }

}

