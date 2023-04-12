package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15565 {
    private static int RYON = 1;
    private static int A_PEACH = 2;
    private int[] check = new int[3];

    public static void main(String[] args) throws IOException {
        BOJ15565 boj15565 = new BOJ15565();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = boj15565.solution(firstLine[1], arr);
        System.out.println(result);
    }

    private int solution(int k, int[] arr) {
        //k 개 이상의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기
        int left = 0, right = 0;
        int result = Integer.MAX_VALUE;
        while (right < arr.length) {
            if (check[RYON] < k) {
                right += 1;
                check[arr[right - 1]] += 1;
            } else {
                result = Math.min(result, check[RYON] + check[A_PEACH]);
                left += 1;
                check[arr[left - 1]] -= 1;
            }
        }
        while (check[RYON] == k) {
            result = Math.min(result, check[RYON] + check[A_PEACH]);
                left += 1;
                check[arr[left - 1]] -= 1;
        }
        if(result== Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
}
