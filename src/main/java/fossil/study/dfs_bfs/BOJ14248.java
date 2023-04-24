package fossil.study.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        System.out.println(solution(n, arr, s));
    }

    private static int solution(int n, int[] arr, int start){
        int answer = 1;

        // 방문 처리를 위한 배열 (0이면 미방문, 1이면 방문)
        int[] visit = new int[n + 1];

        // 왼쪽, 오른쪽 이동
        int[] movement = {-1, 1};

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);
        visit[start] = 1;

        while(!Q.isEmpty()){
            // 현재 위치 및 현재 위치에서 이동 가능한 거리
            int current = Q.poll(), distance = arr[current];

            for(int m : movement){
                // 다음 위치(좌 또는 우)로 이동했을 때의 위치
                int next = (m * distance) + current;

                // 다음 위치가 정상 범위이고, 방문하지 않았다면
                if(next > 0 && next <= n && visit[next] == 0){
                    visit[next] = 1;
                    Q.offer(next);
                    answer++;
                }
            }
        }

        return answer;
    }
}
