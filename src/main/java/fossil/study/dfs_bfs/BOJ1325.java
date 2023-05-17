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
        /*
            1번 노드부터 n번 노드까지 순차적으로 탐색한다.
            탐색을 할 때마다 매번 새로운 visit 배열을 사용한다.
         */
        for(int i = 1; i <= n; i++){
            visit = new int[n + 1];
            visit[i] = 1;
            DFS(i);
        }

        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    /*
        인접 리스트 안에서 방문이 가능하면 다음 노드를 대상으로 탐색.
        방문이 가능한 노드이면 해킹이 가능한 것이므로, 해당 노드가 해킹 가능한
        컴퓨터의 수를 늘려준다.
     */
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
