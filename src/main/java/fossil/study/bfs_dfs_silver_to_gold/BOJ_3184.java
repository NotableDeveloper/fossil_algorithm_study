package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3184 {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new char[firstLine[0]][];
        visited = new boolean[firstLine[0]][firstLine[1]];
        for (int i = 0; i < firstLine[0]; i++) {
            graph[i]=br.readLine().toCharArray();
        }
        int[] solution = solution();
        System.out.println(solution[0] + " "+ solution[1]);
    }
    //result[0]은 양 result[1] 은 늑대
    static private int[] solution(){
        int[] result = {0, 0};
        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[0].length; x++) {
                int[] cnts = dfs(y,x);
                if(cnts[0]>cnts[1]){
                    result[0] += cnts[0];
                }else{
                    result[1] += cnts[1];
                }
            }
        }
        return result;
    }

    private static int[] dfs(int y, int x) {
        int[] result = {0, 0};
        if(!isInRange(y,x)){
            return result;
        }
        if(visited[y][x]){
            return result;
        }
        if(graph[y][x]=='#'){
            return result;
        }
        visited[y][x] = true;
        if(graph[y][x]=='o'){
            result[0] +=1;
        }else if(graph[y][x]=='v'){
            result[1] += 1;
        }
        for (int i = 0; i < dx.length; i++) {
            int[] tmp = dfs(y + dy[i],x + dx[i]);
            result[0] += tmp[0];
            result[1] += tmp[1];
        }
        return result;
    }
    private static boolean isInRange(int y, int x){
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;
    }
}
