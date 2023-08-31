package fossil.study.bfs_dfs_silver_to_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {
    static List<Integer>[] graphList;
    static Set<Integer> visitedSet = new HashSet<>();
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graphList = new List[firstLine[0]];
        answer = new int[firstLine[0]];
        for (int i = 0; i < firstLine[1]; i++) {
            int[] startAndEnd = Arrays.stream(br.readLine().split(" ")).mapToInt((element) -> {
                return Integer.parseInt(element) - 1;
            }).toArray();
            if(Objects.isNull(graphList[startAndEnd[1]])){
                graphList[startAndEnd[1]] = new ArrayList<>();
            }
            graphList[startAndEnd[1]].add(startAndEnd[0]);
        }
        for (Integer result : solution()) {
            System.out.print(result + " ");
        }
    }
    private static List<Integer> solution(){
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i =0; i<graphList.length;i++) {
            if(graphList[i]==null){
                continue;
            }
            visitedSet = new HashSet<>();
            answer[i] = dfs(i);
            max = Math.max(answer[i],max);
        }
        for (int i = 0; i < answer.length; i++) {
            if(answer[i]==max){
                result.add(i+1);
            }
        }
        return result;
    }
    private static int dfs(int curr){
        int size = 1;
        visitedSet.add(curr);
        if(graphList[curr]!=null){
            for (Integer next : graphList[curr]) {
                if(!visitedSet.contains(next)){
                    visitedSet.add(next);
                    size += dfs(next);
                }
            }
        }
        return size;
    }
}
