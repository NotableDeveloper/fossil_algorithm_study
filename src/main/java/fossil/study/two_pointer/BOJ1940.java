package fossil.study.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {
    static int n, m, count = 0;
    static int[] materials, combi;

    private static void DFS(int level, int start){
        if(level == 2){
            int sum = 0;

            for(int i : combi) {
                sum += i;
            }

            if(sum == m) count++;
        }

        else{
            for(int i = start; i < n; i++){
                combi[level] = materials[i];
                DFS(level + 1, i + 1);
            }
        }
    }

    private static int solution(int n, int m, int[] materials) {
        //lt : 배열의 좌측에서 시작, rt : 배열의 우측에서 시작
        int answer = 0, lt = 0, rt = n - 1;

        Arrays.sort(materials);

        while(lt < rt){
            int sum = materials[lt] + materials[rt];

            /*
                좌, 우의 합이 같으면
                좌측 포인터는 이동하고, 우측 포인터는 맨 우측으로
                이동한다.
             */
            if(sum == m){
                answer++;
                lt++;
                rt = n - 1;
            }

            // 좌, 우의 합이 찾는 값보다 크면 좌측만 이동
            else if(sum < m){
                lt++;
            }

            // 좌, 우의 합이 찾는 값보다 작으면 우측만 이동
            else if(sum > m){
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        materials = new int[n];
        combi = new int[2];

        for(int i = 0; i < n; i++){
            materials[i] = sc.nextInt();
        }

        DFS(0, 0);
        System.out.println(count);

        //System.out.println(solution(n, m, materials));
    }
}
