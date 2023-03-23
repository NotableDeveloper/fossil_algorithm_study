package fossil.study.two_pointer;

import java.util.Scanner;

public class BOJ1940 {
    private static int solution(int n, int m, int[] materials) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] materials = new int[n];

        for(int i = 0; i < n; i++){
            materials[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, materials));
    }


}
