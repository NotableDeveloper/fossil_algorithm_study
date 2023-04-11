package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1337 {
    public static void main(String[] args) throws IOException {
        BOJ_1337 boj1337 = new BOJ_1337();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstLine = Integer.parseInt(br.readLine());
        int[] arr = new int[firstLine];
        for (int i = 0; i < firstLine; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i]=tmp;
        }
        Arrays.sort(arr);
        System.out.println(boj1337.solution(arr));

    }
    private int solution(int[] arr){
        int answer = 1;
        int left = 0, right = 1;
        int countOfNumbersInRangeFromLeft = 1;
        if(arr.length == 1){
            return 4;
        }
        while(right<arr.length){
            if(arr[right] - arr[left] <= 4){
                countOfNumbersInRangeFromLeft += 1;
                right += 1;
                answer = Math.max(answer,countOfNumbersInRangeFromLeft);
            }else{
                left += 1;
                right = left + 1;
                countOfNumbersInRangeFromLeft = 1;
            }
        }
        return 5 - answer;
    }
}
