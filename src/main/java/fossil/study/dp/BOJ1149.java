package fossil.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int[][] DP;
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] cost = new int[n][3];

        for(int i = 0; i < n; i++){
            StringTokenizer houseCost = new StringTokenizer(in.readLine());

            cost[i][Red] = Integer.parseInt(houseCost.nextToken());
            cost[i][Green] = Integer.parseInt(houseCost.nextToken());
            cost[i][Blue] = Integer.parseInt(houseCost.nextToken());
        }

        System.out.println(solution(n, cost));
    }

    private static int solution(int n, int[][] cost) {
        DP = new int[n][3];

        for(int i = 1; i < n; i++){
            cost[i][Red] += Math.min(cost[i - 1][Green], cost[i - 1][Blue]);
            cost[i][Green] += Math.min(cost[i - 1][Red], cost[i - 1][Blue]);
            cost[i][Blue] += Math.min(cost[i - 1][Red], cost[i - 1][Green]);
        }

        return Math.min(Math.min(cost[n - 1][Red], cost[n - 1][Green]), cost[n - 1][Blue]);
    }
}
