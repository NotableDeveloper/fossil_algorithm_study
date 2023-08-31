package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//완전 탐색
public class BOJ_1941 {
    static char[][] graph = new char[5][];
    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            graph[i] = br.readLine().toCharArray();
        }
    }
    private char[] bfs(int startY, int startX){
        int s = 0;
        int y = 0;
        for (int i = 0; i < 7; i++) {

        }
        return null;
    }
}
