package fossil.study.two_pointer;

import java.util.Scanner;

public class BOJ1806 {
    private static int solution(int n, int s, int[] arr){
        int answer = Integer.MAX_VALUE, left = 0, right = 0;
        int sum = 0;

        while(true){
            // 현재 부분합이 s 이상인 경우
            if(sum >= s) {
                sum -= arr[left++];
                answer = Math.min(answer, right - left + 1);
            }

            // 오른쪽 포인터가 수열의 끝에 도달한 경우
            else if(right == n) break;

            // 현재 부분합이 s 미만인 경우
            else{
                sum += arr[right++];
            }
        }

        if(answer == Integer.MAX_VALUE) answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, s, arr));
    }
}
