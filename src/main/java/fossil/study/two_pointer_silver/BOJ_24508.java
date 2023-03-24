package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_24508 {
    public static void main(String[] args) throws IOException {
        BOJ_24508 boj24508 = new BOJ_24508();
        InputStreamReader stdInputStream = new InputStreamReader(System.in);
        if(boj24508.solve(stdInputStream)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
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
        Integer[] numberOfNadoriInBucket = Arrays.stream(br.readLine().split(" ")).sorted()
                .map(Integer::parseInt).toArray(Integer[]::new);
        if(!canBoomAllNadori(numberOfNadoriInBucket,nadoriBoomNumber)){
            return false;
        }
        return moveNadori(numberOfNadoriInBucket,nadoriBoomNumber,numberOfMoves);

    }

    private boolean moveNadori(Integer[] numberOfNadoriInBucket, int targetNumber, int numberOfMoves) {
        int left = 0,right = numberOfNadoriInBucket.length-1;
        while(left<right){
            if(numberOfNadoriInBucket[left]<targetNumber){
                if(numberOfNadoriInBucket[left] == 0){
                    left+=1;
                }
                if(numberOfNadoriInBucket[left]!=0){
                    numberOfNadoriInBucket[left] -= 1;
                    numberOfNadoriInBucket[right] += 1;
                    if(numberOfMoves>0){
                        numberOfMoves -= 1;
                    }else{
                        break;
                    }
                }
            } if(numberOfNadoriInBucket[right]==targetNumber){
                numberOfNadoriInBucket[right] = 0;
                right-=1;
            }
        }
        if(left<right){
            return false;
        }
        return numberOfNadoriInBucket[left] >= 0;
    }

    private boolean canBoomAllNadori(Integer[] numberOfNadoriInBucket, int nadoriBoomNumber){
        int sumOfNadori = Arrays.stream(numberOfNadoriInBucket).mapToInt(Integer::intValue).sum();
        int remain = sumOfNadori % nadoriBoomNumber;
        return remain == 0;
    }
}
