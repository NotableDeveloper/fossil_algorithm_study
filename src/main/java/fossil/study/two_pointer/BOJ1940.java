package fossil.study.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {
    private static int solution(int n, int m, int[] materials) {
        int answer = 0, lt = 0, rt = n - 1;

        Arrays.sort(materials);

        while(lt < rt){
            int sum = materials[lt] + materials[rt];

            if(sum == m){
                answer++;
                lt++;
                rt = n - 1;
            }

            else if(sum < m){
                lt++;
            }

            else if(sum > m){
                rt--;
            }
        }

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
