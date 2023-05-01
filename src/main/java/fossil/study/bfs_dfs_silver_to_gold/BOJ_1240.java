package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1240 {
    static int[][] graph ;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=firstLine[0];
        int m = firstLine[1];
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < n-1; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int parent = tmp[0];
            int leaf = tmp[1];
            int distance = tmp[2];
            graph[parent][leaf] = distance;
            graph[leaf][parent] = distance;
        }
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = tmp[0];
            int end = tmp[1];
            System.out.println(solution(start,end));
            visited = new boolean[n+1];
        }

    }

    private static int solution(int start, int end) {
        return dfs(start,end);
    }

    private static int dfs(int start, int target) {
        visited[start] = true;
        if(start == target){
            return 0;
        }
        for (int i = 0; i < graph.length; i++) {
            if(graph[start][i]!=0 && !visited[i]){
                int tmp = dfs(i,target);
                if(tmp != -1){
                    return tmp + graph[start][i];
                }
            }
        }
        return -1;
    }
}
