package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BOJ_1253 {
    boolean zeroIsGood = false;
    public static void main(String[] args) throws IOException {
        BOJ_1253 boj1253 = new BOJ_1253();
        int result = boj1253.solve();
        System.out.println(result);
    }

    public int solve() throws IOException {
        // 좋은 수의 갯수는?
        //좋은 수 = 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다.
        //ex 1 2 3 에서 3은 좋은 수 이다 ( 1 + 2 로 나타낼 수 있으니까)
        //수의 위치가 다르면 값이 같아도 다른 수이다.
        // 예제
        //1 2 3 4 5 6 7 8 9 10 -> 8
        // 3: 1 + 2
        // 4: 1 + 3
        // 5: 2 + 3 , 1+ 4
        // 6: 2+4,1+5
        // 7: 3+4, 1+6, 2+5
        // 8 : 1+7, 2+6, 3+5
        // 9 : 1+8 ~~~
        // 10 : 1+9 ~~~
        //3,4,5,6,7,8,9,10 => 8개

        //수의 갯수는 최대 2000개
        //n^2 까지는 OK

        //좋은수가 된다 -> 나보다 작은 수들 중 나를 만들 수 있는 두 수가 있다.

        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] secondInputs = br.readLine().split(" ");
        List<Integer> numbers = Arrays.stream(secondInputs).map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList());
        //        numbers.forEach(System.out::println);

        for (int i = 0; i < numbers.size(); i++) {

            if (isGoodNmber(i, numbers)) {
                result += 1;
            }
//            if(numbers.get(0) == 0){
//                if(zeroIsGood){
//                    result += 1;
//                }
//            }

        }
        return result;
    }

    private boolean isGoodNmber(int targetNumberIdx, List<Integer> targetArray) {

        Integer targetNumber = targetArray.get(targetNumberIdx);
        int left = 0;
        int right = targetArray.size() - 1;
        if(right <= 1){
            return false;
        }
        while (left < right) {
            int leftPlusRight = targetArray.get(left) + targetArray.get(right);
            if(left == targetNumberIdx){
                left += 1;
                continue;
            }
            if(right == targetNumberIdx){
                right -= 1;
                continue;
            }
            if (leftPlusRight < targetNumber) {
                left += 1;
            } else if (leftPlusRight == targetNumber) {
                return true;
            } else {
                right -= 1;
            }
        }
        return false;
    }
}
