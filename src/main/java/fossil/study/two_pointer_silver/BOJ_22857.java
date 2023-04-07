package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_22857 {
    int[] check = new int[2];

    public static void main(String[] args) throws IOException {
        BOJ_22857 boj22857 = new BOJ_22857();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = boj22857.solution(firstLine[1], arr);
        System.out.println(res);
    }

    public int solution(int k, int[] arr) {
        //k = 허용되는 홀수의 갯수
        int left = 0, right = 0;
        int result = 0;
        while (right < arr.length) {
            if (check[1] <= k) {
                result = Math.max(result, check[0]);
                right += 1;
                check[arr[right - 1] % 2] += 1;
            } else {

                left += 1;
                check[arr[left - 1] % 2] -= 1;
            }
        }
        if (check[1] <= k) {
            result = Math.max(result, check[0]);
        }

        return result;
    }
}
