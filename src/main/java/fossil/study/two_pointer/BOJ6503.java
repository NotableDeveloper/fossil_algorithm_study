package fossil.study.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Test{
    int m;
    String str;
    /*
        정상적인 입력이 가능한 키가 될 수 있는 128개 문자에 대한 Check 배열
        0이면 주어진 문자열에 입력할 필요가 없는 키이고, 1 이상은 그만큼
        입력해야 한다는 의미이다.
     */
    int[] check;

    public Test(int m, String str){
        this.m = m;
        this.str = str;
        this.check = new int[128];
    }

    public void solution(){
        // count : Sliding window 안에서 서로 다른 문자의 갯수
        int answer = 0, left = -1, right = -1, count = 0;

        while(left <= right){
            /*
                m개 미만의 키를 사용하지 않았거나,
                m개 만큼 입력하고 현재 right 위치의 키를 1번 이상 입력한 경우
             */
            if(count < m || (count == m && check[str.charAt(right + 1)] > 0)){
                // 다음 문자를 입력한 것으로 처리
                right++;
                check[str.charAt(right)]++;

                /*
                    다음 문자를 현재 window에서 처음 입력한 것이라면,
                    window 안에서 서로 다른 문자를 하나 찾은 것임
                 */
                if(check[str.charAt(right)] == 1) count++;
            }

            // count가 m개를 초과한 경우
            else {
                left++;
                check[str.charAt(left)]--;

                if(check[str.charAt(left)] == 0) count--;
            }

            // 매번 갱신되는 window의 최대 값을 갱신
            answer = Math.max(answer, right - left);

            if(right == str.length() - 1) break;
        }

        System.out.println(answer);
    }
}

public class BOJ6503 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Test> tcl = new ArrayList<>();

        while(true){
            String input = in.readLine();

            if(input.equals("0")) break;

            int m = Integer.parseInt(input);
            input = in.readLine();

            tcl.add(new Test(m, input));
        }

        for(Test t : tcl){
            t.solution();
        }
    }
}
