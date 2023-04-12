package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        //구하고자하는 최소길이 출력
        //입력 N,S,수열
        BOJ_1806 boj1806 = new BOJ_1806();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] firstLine =  Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arr =  Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int result = boj1806.solution(firstLine[0], firstLine[1], arr);
        System.out.println(result);
    }
    private int solution(int N, int S, Integer[] arr){
        int left = 0,right = 0,minLength = 100001;
        int sum = arr[left];
        try{
            while(left<=right){
                if(sum>=S){
                    minLength= Math.min(right - left + 1,minLength);
                    sum -= arr[left];
                    left += 1;
                }else{
                    right += 1;
                    sum += arr[right];
                }
            }
        }catch (Exception ignore){

        }

        if(minLength == 100001){
            return  0;
        }else{
            return minLength;
        }
    }
}
