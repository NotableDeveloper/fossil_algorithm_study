package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BOJ_20922 boj20922 = new BOJ_20922();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] targetArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = boj20922.solution(firstLine[0], firstLine[1], targetArray);
        System.out.println(result);
    }
    public int solution(int n, int k, int[] arr){
        int[] cache = new int[100001];
        int left = 0, right = 1;
        cache[arr[left]] += 1;
        int maxLength = 0;
        while(right < arr.length){
            if(cache[arr[right-1]] <= k){
                maxLength = Math.max(right-left,maxLength);
            }
            if(cache[arr[right-1]] <= k){
                right += 1;
                cache[arr[right -1]] += 1;
            }else {
                cache[arr[left]] -= 1;
                left += 1;
            }
        }
        if(cache[arr[right-1]] <= k){
            maxLength = Math.max(right-left,maxLength);
        }
        return maxLength;
    }
}
