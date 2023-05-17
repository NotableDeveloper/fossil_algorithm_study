package fossil.study.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1325 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputString = new StringTokenizer(in.readLine());

        n = Integer.parseInt(inputString.nextToken());
        m = Integer.parseInt(inputString.nextToken());

        graph = new ArrayList();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        answer = new int[n + 1];

        for(int i = 0; i < m; i++){
            inputString = new StringTokenizer(in.readLine());

            int trusting = Integer.parseInt(inputString.nextToken());
            int trusted = Integer.parseInt(inputString.nextToken());

            graph.get(trusting).add(trusted);
        }

        for(int i = 1; i <= n; i++){
            visit = new int[n + 1];
            visit[i] = 1;
            DFS(i);
        }

        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    public static void DFS(int node){
        for(int next : graph.get(node)){
            if(visit[next] == 0){
                answer[next]++;
                visit[next] = 1;
                DFS(next);
            }
        }
    }
}
