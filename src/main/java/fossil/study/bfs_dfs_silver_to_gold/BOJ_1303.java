package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_1303 {
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new char[firstLine[1]][];
        for (int i = 0; i < firstLine[1]; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        visited = new boolean[graph.length][graph[0].length];
        int[] solution = solution();
        System.out.println(solution[0] + " " + solution[1]);
    }
    private static int[] solution(){
        int[] result = new int[2];
        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[0].length; x++) {
                if(!visited[y][x]){
                    int dfs = dfs(y, x);
                    if(graph[y][x]=='W'){
                        result[0] += Math.pow(dfs,2);
                    }else{
                        result[1] += Math.pow(dfs,2);
                    }
                }
            }
        }
        return result;
    }
    private static int dfs(int startY, int startX){
        Stack<int[]> stack = new Stack<>();
        int result = 1;
        visited[startY][startX] = true;
        stack.push(new int[]{startY,startX});
        while(!stack.isEmpty()){
            int[] currPoint = stack.pop();
            int currY = currPoint[0];
            int currX = currPoint[1];
            char currColor = graph[currY][currX];
            for (int i = 0; i < dx.length; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if(!isInRange(nextY,nextX) || graph[nextY][nextX]!= currColor || visited[nextY][nextX]){
                    continue;
                }else{
                    visited[nextY][nextX] = true;
                    result += 1;
                    stack.push(new int[]{nextY,nextX});
                }

            }
        }
        return result;
    }
    private static boolean isInRange(int y, int x){
        return y>=0 && y< graph.length && x>=0 && x< graph[0].length;
    }
}
