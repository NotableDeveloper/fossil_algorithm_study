package fossil.study.dp_s4_to_g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ1099 {
    //단어길이 최대 50
    static int[][] cache; //cache[시작][끝] = 비용
    static String[] strings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstLine = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]= br.readLine();
        }
    }
//    private static int solution(int length){
//        return dp(0, length);
//    }
//    private static int dp(int start,int end){
//        int middle = 0;
//        int minValue = 0;
//        if(start == end){
//
//        }
//        for (int i = 0; i < end; i++) {
//
//        }
//        cache[start][end] = dp(start,middle) + dp(middle,end);
//    }
//    private static int getValue(int start, int end,String targetString){
//
//        if(end-start+1 == ){
//
//        }
//        String substring = targetString.substring(start, end);
//
//        substring.contains()
//    }
}
