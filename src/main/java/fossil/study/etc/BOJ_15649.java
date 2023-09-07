package fossil.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_15649 {
    static boolean[] visited;
    static List<Integer[]> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(
                br.readLine().split(" ")
        ).mapToInt(Integer::parseInt).toArray();
        int n = firstLine[0];
        int m = firstLine[1];
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(list, m, n);
        }
        ;
        for (Integer[] list : resultList) {
            for (Integer number : list) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(List<Integer> list, int m, int n) {
        if (list.size() == m) {
            resultList.add(list.toArray(new Integer[0]));
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                list.add(i);
                dfs(list, m, n);
                list.remove(list.size() - 1);
                visited[i]=false;
            }
        }
    }
}
