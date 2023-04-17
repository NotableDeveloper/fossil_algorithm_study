package fossil.study.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0, left = 0, right = 1, sum = arr[0];

        while(true){
            if(sum < m){
                if(right < n) sum += arr[right++];
                else break;
            }

            else if(sum == m){
                answer++;
                sum -= arr[left++];
            }

            else sum -= arr[left++];
            }

        return answer;
    }
}
