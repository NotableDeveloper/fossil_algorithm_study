package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_24508 {
    public static void main(String[] args) throws IOException {
        BOJ_24508 boj24508 = new BOJ_24508();
        InputStreamReader stdInputStream = new InputStreamReader(System.in);
        if(boj24508.solve(stdInputStream)){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        };
    }
    private boolean solve(InputStreamReader inputStreamReader) throws IOException {
        // T 회 이하로 반복해서 모든 나도리를 터트릴 수 있는지 여부
        //K 마리가 하나의 바구니에 있게 되면 나도리는 터진다.
        //N 개의 바구니가 있다.
        //T 가 10^9 까지라 O(n) 도 안됨(직접 T번 해본다는 안됨)

        BufferedReader br = new BufferedReader(inputStreamReader);
        List<Integer> firstLine = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int numberOfBucket = firstLine.get(0);
        int nadoriBoomNumber = firstLine.get(1);
        int numberOfMoves = firstLine.get(2);
        int[] numberOfNadoriInBucket = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted()
                .toArray();
        return solution(numberOfNadoriInBucket, nadoriBoomNumber, numberOfMoves);
    }
    private boolean solution( int arr[],int k, int t){
        int left = 0, right = arr.length - 1;
        int cntOfMoveNadori = 0;
        while(left!=right){
            if(cntOfMoveNadori > t){
                return false;
            }
            if(arr[right] == k){
                arr[right] = 0;
                right -= 1;
                continue;
            }
            if(arr[left] == 0){
                left += 1;
                continue;
            }
            //나도리를 움직인다
            arr[left] -= 1;
            arr[right] += 1;
            cntOfMoveNadori += 1;
            //-------
        }
        if (arr[right] == k || arr[right] == 0 ) {
            return true;
        }
        return false;
    }
}
