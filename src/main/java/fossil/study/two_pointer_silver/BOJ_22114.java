package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BOJ_22114 {
    public static void main(String[] args) throws IOException {
        BOJ_22114 boj22441 = new BOJ_22114();
        InputStreamReader stdInputStreamReader = new InputStreamReader(System.in);
        System.out.println(boj22441.solve(stdInputStreamReader));
    }
    private int solve(InputStreamReader inputStreamReader) throws IOException {
        //회색 보도블럭 + 빨간 보도블럭
        // 빨간거만 밟고 이동하기
        //총 N개의 블러이 직선상에 놓여았음
        //1,2,...N 번 블럭
        //i 번 블럭과 i + 1번 블럭은 Li 만큼 떨어져 있음
        //한 걸음에 K 만ㅌ큼 이동할 수 있다.
        // i에서 i+1 로 가려면 Li<=k
        //거리 상관없이 1번 이동할 수 있음
        //다음블럭을 밟지 못하면 기록은 거기서 끝난다.
        //최적의 시작점을 찾아 최고 기록을 세우기 몇개의 블럭을 연속으로 밟을 까??
        //투포인터를 쓰기 위해선 정렬되어 있어야 한다.
        //슬라이딩 윈도우로 푸는거 같은 느낌쓰
        BufferedReader br = new BufferedReader(inputStreamReader);
        Map<String, Integer> indicator = new HashMap<>();
        int maxNumberOfUsedBlock = 0;
        List<Integer> firstLine = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        indicator.put("N",firstLine.get(0));
        indicator.put("K",firstLine.get(1));

        List<Integer> Li = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < indicator.get("N"); i++) {
            maxNumberOfUsedBlock = Math.max(maxNumberOfUsedBlock, numberOfUsedBlock(i, Li, indicator.get("K")));
        }
        return maxNumberOfUsedBlock;
    }
    private int numberOfUsedBlock(int start, List<Integer> distancesFromIBlockToNext, int maxDistanceInOnce){
        boolean canJump = true;
        int curBlock = start;
        int result = 1;
        try{
            while(distancesFromIBlockToNext.get(curBlock) <= maxDistanceInOnce || canJump){
                if(distancesFromIBlockToNext.get(curBlock) > maxDistanceInOnce){
                    canJump = false;
                }
                curBlock++;
                result+=1;
            }
        } catch (IndexOutOfBoundsException ignored){
        }finally {
            return result;
        }

    }
}
