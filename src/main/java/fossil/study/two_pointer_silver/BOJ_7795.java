package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BOJ_7795 boj7795 = new BOJ_7795();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTest = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfTest; i++) {
            int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            stringBuilder.append(boj7795.solution(arrA,arrB));
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }
    private int solution(int[] arrA, int[] arrB){
        int cursorB = 0,cursorA =0;
        int res = 0;
        while (cursorB < arrB.length && cursorA < arrA.length){
            if(arrA[cursorA] > arrB[cursorB]){
                cursorB += 1;
            }else{
                res += cursorB;
                cursorA += 1;
            }
        }
        if(cursorB == arrB.length){
            res += (arrA.length - cursorA ) * cursorB;
        }
        return res;
    }
}
