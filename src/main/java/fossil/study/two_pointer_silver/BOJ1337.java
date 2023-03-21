package fossil.study.two_pointer_silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1337 {
    private static int solution(int n, int[] arr) {
        /*
            count : Sliding window 안에서 차이가 5 미만인 수의 갯수
            start : Sliding window 의 시작 지점
        */
        int answer = 1, count = 1, start = 0;
        Arrays.sort(arr);

        for(int i = 1; i < n; i++){
            count++;

            while(arr[i] - arr[start] > 4){
                start++;
                count--;
            }

            // 현재까지 탐색한 Sliding window에서 연속된 수의 갯수가 가장 많은 것을 저장
            answer = Integer.max(answer, count);
        }
        // 연속된 수의 갯수가 5회를 넘어가면 올바른 배열
        if(answer > 5) answer = 5;
        // 연속된 수의 갯수에서 5를 빼면 추가해야 하는 원소의 수
        else answer = 5 - answer;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }

}
