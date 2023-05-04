package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2606 {
    private static boolean[][] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < edge; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startNode = tmp[0];
            int endNode = tmp[1];
            graph[startNode][endNode] = true;
            graph[endNode][startNode] = true;
        }
        System.out.println(solution());
    }
    private static int solution(){
        return dfs(1)-1;
    }

    private static int dfs(int startNode) {
        int size = 1;
        visited[startNode] = true;
        for (int i = 1; i < graph.length; i++) {
            if(graph[startNode][i]){
                int nextNode = i;
                if(visited[nextNode]){
                    continue;
                }else{
                    visited[nextNode] = true;
                    size += dfs(nextNode);
                }

            }
        }
        return size;
    }
}
