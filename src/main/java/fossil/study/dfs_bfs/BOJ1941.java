package fossil.study.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941 {
    static char[][] table;
    static int answer;
    // 좌표 값의 방문 여부
    static boolean[] visited;
    // 7명의 학생 조합
    static int[] students = new int[7];
    static int[] X = {-1, 1, 0, 0};
    static int[] Y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        table = new char[5][5];

        for (int i = 0; i < 5; i++) {
            table[i] = br.readLine().toCharArray();
        }

        Comb(0, 0, 0);
        System.out.println(answer);
    }

    /*
        25명의 학생 중에서 7명의 학생을 뽑는다.
        7명의 학생을 BFS를 통하여 인접하는 지 확인한다.
     */
    static void Comb(int count, int start, int dasom) {
        // 이다솜파 학생이 4명 미만이면 확인할 필요가 없는 조합이다.
        if (count - dasom > 3) return;

        if (count == 7) {
            // visited : 해당 조합의 멤버들 위치를 탐색했는 지의 여부를 나타낸다.
            visited = new boolean[7];
            // 조합의 첫 번째 학생을 기준으로 탐색을 시작한다.
            BFS(students[0]/5, students[0]%5);
            return;
        }

        // 0번 학생부터 24번째 학생 중에서 7명을 뽑는다.
        for (int i = start; i < 25; i++) {
            int row = i / 5, col = i % 5;
            students[count] = i;

            // 현재 위치의 학생이 이다솜파 학생이라면, 카운팅 값을 하나 증가시킴
            if(table[row][col] == 'S')
                Comb(count + 1, i + 1, dasom + 1);

            else Comb(count + 1, i + 1, dasom);
        }

    }

    static void BFS(int x, int y) {
        // student : 인접한 학생이 몇 명인 지를 카운팅하기 위한 변수
        int student = 1;

        // 첫 번째 학생의 방문 처리 및 Queue 초기화
        visited[0] = true;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x, y});

        while (!Q.isEmpty()) {
            int[] current = Q.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + X[i], nc = c + Y[i];

                // 영역 범위를 벗어나면 다음 위치 탐색
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                /*
                    다음에 위치한 학생이 몇 번째 학생인 지를 계산한다.
                    X 좌표는 한 변의 길이(= 5)를 나눈 값이 되고,
                    Y 좌표는 한 변의 길이(= 5)를 나눈 나머지 값이 된다.
                 */
                int nextPosition = 5 * nr + nc;

                // 7명의 학생 중에서 인접한 학생인 지와 조합에 속한 학생이 맞는 지를 확인
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && students[k] == nextPosition) {
                        visited[k] = true;
                        student++;
                        Q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        if (student == 7) answer++;
    }
}