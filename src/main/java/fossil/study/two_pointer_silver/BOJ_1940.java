package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        InputStreamReader stdInputStream = new InputStreamReader(System.in);
        BOJ_1940 boj1940 = new BOJ_1940();
        System.out.println(boj1940.solve(stdInputStream));
    }
    private int solve(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader br = new BufferedReader(inputStreamReader);
        int N = Integer.parseInt(br.readLine());//재료의 갯수
        int M = Integer.parseInt(br.readLine());//갑옷을 만드는데 필요한 수(2개를 합쳤을 때 이 수가 나오면 됨)
        List<Integer> identityNumber = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
        return numberOfPairThatBecomeTargetNumber(identityNumber,M);
    }
    private int numberOfPairThatBecomeTargetNumber(List<Integer> targetList, int targetNumber){
        int left = 0;
        int right = targetList.size()-1;
        int result = 0;
        while(left<right){
            int tmpNumber = targetList.get(left) + targetList.get(right);
            if(tmpNumber < targetNumber){
                left+=1;
            } else if (tmpNumber == targetNumber) {
                result += 1;
                left+=1;
            } else{
                right-=1;
            }
        }
        return result;
    }
}
