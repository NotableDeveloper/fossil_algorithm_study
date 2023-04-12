package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10025 {
    static int[] map = new int[1000000];
    public static void main(String[] args) throws IOException {
    //얼음들의 합의 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < firstLine[0]; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[arr[1]] = arr[0];
        }
        BOJ_10025 boj10025 = new BOJ_10025();
        System.out.println(boj10025.solution(firstLine[1],map));
    }
    private int solution(int k, int[] arr){
        int left = -k, right = k;
        int currSum = 0,maxSum = -1;
        for(int i = left; i<= right;i++){
            try{
                currSum += arr[i];
            }catch (Exception e){
                currSum += 0;
            }
        }
        maxSum = currSum;

        while(right<arr.length){
            maxSum = Math.max(currSum,maxSum);
            try{
                currSum -= arr[left];
            }catch (Exception e){
                currSum -= 0;
            }
            left += 1;
            right += 1;
            try {
                currSum += arr[right];
            }catch (Exception e){
                currSum += 0;
            }
        }
        return maxSum;
    }

}
