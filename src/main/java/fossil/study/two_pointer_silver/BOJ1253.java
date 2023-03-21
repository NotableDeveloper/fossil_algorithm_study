package fossil.study.two_pointer_silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1253 {
    public static int solution(int n, int[] arr){
        int answer = 0;
        // 배열 오름차순 정렬
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            // lt : 배열의 시작(왼쪽), rt : 배열의 끝(오른쪽)
            int find = arr[i], lt = 0, rt = (n - 1), sum = 0;

            while(lt < rt){
                sum = arr[lt] + arr[rt];

                // 두 포인터가 가리키는 곳의 합이 같으면 찾은 경우이다.
                if(find == sum){
                    // 또 다른 GOOD을 찾기 위해 포인터 위치 조정
                    if(i == lt) lt++;
                    else if(i == rt) rt--;

                    else{
                        answer++;
                        break;
                    }
                }

                // 또 다른 GOOD를 찾기 위해 포인터 위치 조정
                if(arr[lt] + arr[rt] > find) rt--;
                else if(arr[lt] + arr[rt] < find) lt++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
