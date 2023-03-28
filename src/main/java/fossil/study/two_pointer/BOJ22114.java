package fossil.study.two_pointer;

import java.util.Scanner;

public class BOJ22114 {
    private static int solution2(int n, int k, int[] block){
        // 두 포인터는 배열의 좌측에서 시작함
        int p1 = 0, p2 = 0;
        int count = 1, check = 0;
        // jump가 참이면 점프를 했음을 나타내고, false이면 하지 않았음을 나타냄
        boolean jump = false;
        int answer = 0;

        while(true){
            // 포인터 중에 하나가 block 배열 끝에 닿으면 종료
            if(p1 == (n - 1) || p2 == (n - 1)) break;

            // 우측 포인터가 간격 이내의 값이면
            if(block[p2] <= k){
                count++;
                p2++;
            }

            // 우측 포인터가 간격을 벗어나는 값이면
            else if(block[p2] > k){
                // 점프를 하지 않았다면
                if(!jump){
                    jump = true;
                    count++;
                    check = p2;
                    p2++;
                }
                // 점프를 했다면
                else{
                    p1 = check + 1;
                    p2 = p1;
                    answer = Math.max(answer, count);
                    count = 1;
                    check = 0;
                    jump = false;
                }
            }
        }

        answer = Math.max(answer, count);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] block = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            block[i] = sc.nextInt();
        }

        System.out.println(solution2(n, k, block));
    }
}
