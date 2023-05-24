package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ2638 {
    final static int INNER_SPACE = 0;
    final static int OUTTER_SPACE = 4;
    final static int STABLE_CHEASE = 1;
    final static int WILL_DISAPEAR = 2;
    static int remainChease = 0;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[firstLine[0]][];
        for (int i = 0; i < firstLine[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1){
                    remainChease++;
                }
            }
        }
        System.out.println(solution());

    }
    static private int solution(){
        int time = 0;
        makeOutterBfs(0,0);
        while(remainChease>0){
            innerCheck();
            melt();
            time++;
        }
        return time;
    }

    private static void melt() {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if(!visited[y][x] && map[y][x] == STABLE_CHEASE){
                    makeMeltChease(y,x,visited);
                }
            }
        }
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if(map[y][x] == WILL_DISAPEAR){
                    map[y][x] = OUTTER_SPACE;
                }
            }
        }
    }

    private static void makeMeltChease(int y,int x, boolean[][] visited) {
        int cntOfOutsideSpace = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        while (!queue.isEmpty()){
            cntOfOutsideSpace = 0;
            int currY = queue.peek()[0];
            int currX = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];
                if(!inRange(nextY,nextX)){
                    continue;
                }
                if(map[nextY][nextX]==OUTTER_SPACE){
                    cntOfOutsideSpace++;
                }
                if(!visited[nextY][nextX] && map[nextY][nextX]==STABLE_CHEASE){
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                }
            }
            if(cntOfOutsideSpace>=2){
                map[currY][currX] = WILL_DISAPEAR;
                remainChease--;
            }
        }
    }
    private static void innerCheck() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if(map[y][x]!= INNER_SPACE){
                    continue;
                }else if(isOutside(y,x)){
                    makeOutterBfs(y,x);
                }
            }
        }
    }

    private static boolean isOutside(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(map[nextY][nextX] == OUTTER_SPACE){
                return true;
            }
        }
        return false;
    }

    private static void makeOutterBfs(int y,int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        while (!queue.isEmpty()){
            int currY = queue.peek()[0];
            int currX = queue.peek()[1];
            queue.poll();
            map[currY][currX] = OUTTER_SPACE;
            for (int i = 0; i < dx.length; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];
                if(!inRange(nextY,nextX)){
                    continue;
                }
                if(!visited[nextY][nextX] && map[nextY][nextX]==0){
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
    private static boolean inRange(int y, int x){
        return 0<=y && y<map.length && 0<=x && x<map[0].length;
    }
}
