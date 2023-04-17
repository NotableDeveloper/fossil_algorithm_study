package fossil.study.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15565 {
    // 라이언 인형의 위치를 저장
    public static ArrayList<Integer> ryan = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number == 1) ryan.add(i);
        }

        System.out.println(solution(k));
    }

    private static int solution(int k) {
        // 라이언 인형의 수가 k개 미만이면 무조건 -1
        if(ryan.size() < k) return -1;

        /*
            distance : 라이언 인형이 K개가 포함되는 부분의 시작 지점과 끝 지점의
            위치 값을 빼주면 해당 부분의 전체 길이가 나온다.
         */
        int answer = Integer.MAX_VALUE, left = 0, right = k - 1, distance = 0;

        while(true){
            if(right == ryan.size()) break;
            distance = ryan.get(right) - ryan.get(left) + 1;
            answer = Math.min(answer, distance);

            left++;
            right++;
        }

        return answer;
    }
}
