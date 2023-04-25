package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14248 {
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BOJ_14248 boj14248 = new BOJ_14248();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[graph.length];
        int start = Integer.parseInt(br.readLine());
        System.out.println(boj14248.solution(start));
    }
    private int solution(int start){
        return bfs(start-1);
    }
    private int bfs(int start){
        int result = 1;
//        start = start-1;
        if(start<0||start>=graph.length){
            return 0;
        }
        if(visited[start]){
            return 0;
        }
        visited[start] = true;

        result += bfs(start - graph[start]) + bfs(start + graph[start]);
        return result;
    }

}
