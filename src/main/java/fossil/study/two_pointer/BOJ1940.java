package fossil.study.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] materials = new int[n];

        for(int i = 0; i < n; i++){
            materials[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, materials));
    }


}
