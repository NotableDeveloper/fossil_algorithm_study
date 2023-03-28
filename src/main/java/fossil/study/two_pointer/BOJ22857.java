package fossil.study.two_pointer;

import java.util.Scanner;

public class BOJ22857 {
    /*
        최대 K개의 홀수가 담긴 부분 수열 중에서 가장 큰
        길이를 갖는 배열을 찾는 것으로 생각
     */
    private static int solution(int n, int k, int[] numbers){
        // oddCount : 부분 수열 안에서 홀수의 갯수
        int answer = 0, oddCount = 0;
        int lt = 0, rt = 0;

        while(rt < n){
            // K개를 초과하는 홀수가 window에 담긴 경우
            if(oddCount > k){
                if(numbers[lt] % 2 == 1){
                    oddCount--;
                }
                // window를 축소
                lt++;
            }

            // window 안의 홀수의 갯수가 아직 K개를 초과하지 않은 경우
            else{
                if(numbers[rt] % 2 == 1){
                    oddCount++;
                }
                // window를 늘림
                rt++;
            }

            // window 안의 홀수의 갯수가 k개 이상이 된 경우
            if(oddCount <= k){
                // evenCount : window 안에서 짝수의 갯수
                int evenCount = rt - lt - oddCount;
                answer = Math.max(answer, evenCount);
            }
        }

        return answer;
    }

    private static int solution2(int n, int k, int[] numbers){
        int answer = 0, count = 0;
        int lt = 0, rt = 1;

        while(rt < n){
            if(numbers[lt] % 2 == 1){

            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, numbers));
    }
}

