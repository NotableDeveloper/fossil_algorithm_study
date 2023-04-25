package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2644 {
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] secondLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[people[0]][people[1]] = true;
            graph[people[1]][people[0]] = true;
        }
        System.out.println(solution(secondLine[0],secondLine[1]));
    }

    private static int solution(int start, int target) {
        return bfs(start,target);
    }
    private static int bfs(int start,int target){
        int result = 1;
        if(start == target){
            return 0;
        }
        visited[start] = true;
        for (int i = 1; i < graph.length; i++) {
            if(graph[start][i] && !visited[i]){
                int tmp = bfs(i,target);
                if(tmp != -1){
                    return result + tmp;
                }
            }
        }
        return -1;
    }
}
