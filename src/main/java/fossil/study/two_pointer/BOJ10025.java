package fossil.study.two_pointer;

import java.util.Scanner;

public class BOJ10025 {
    // 앨버트의 우리 안에 존재할 수 있는 양동이의 수
    public static int bucket = 1000001;
    private static int solution(int k, int[] home){
        // window_length = 좌에서 k만큼, 우에서 k만큼의 길이를 갖도록 하는 윈도우
        int answer = 0, sum = 0, window_length = k * 2 + 1;

        for(int i = 0; i < bucket; i++){
            // window 길이만큼 탐색을 했으면 크기 계산
            if(i >= window_length){
                sum -= home[i - window_length];
            }

            // window 크기 누적
            sum += home[i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] home = new int[bucket];

        for(int i = 0; i < n; i++){
            int ice = sc.nextInt();
            int pos = sc.nextInt();
            home[pos] = ice;
        }

        System.out.println(solution(k, home));
    }
}
