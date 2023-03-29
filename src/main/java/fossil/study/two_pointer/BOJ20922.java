package fossil.study.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
    private static int solution(int n, int k, int[] arr) {
        int answer = 0, lt = 0, rt = 0;
        int[] count = new int[100001];

        while(lt < n){
            if(count[arr[lt]] != k){
                count[arr[lt]]++;
                lt++;
            }

            else{
                count[arr[rt]]--;
                rt++;
            }

            answer = Math.max(answer, lt - rt);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(in.readLine());

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k, arr));
    }
}
