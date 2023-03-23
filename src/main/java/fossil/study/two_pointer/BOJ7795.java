package fossil.study.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class TestCase{
    public TestCase(int[] arr1, int[] arr2){
        A = arr1;
        B = arr2;
        Arrays.sort(A);
        Arrays.sort(B);
    }

    int[] A;
    int[] B;

    public void solution(){
        int count = 0, idx = 0;

        for(int i = 0; i < A.length; i++){
            while(idx < B.length && A[i] > B[idx]){
                idx++;
            }
            count += idx;
        }

        System.out.println(count);
    }
}

public class BOJ7795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<TestCase> tcl = new ArrayList<>();

        for(int i = 0; i < T; i++){
            int size_A = sc.nextInt();
            int size_B = sc.nextInt();

            int[] arr1 = new int[size_A];
            int[] arr2 = new int[size_B];

            for(int j = 0; j < size_A; j++){
                arr1[j] = sc.nextInt();
            }

            for(int k = 0; k < size_B; k++){
                arr2[k] = sc.nextInt();
            }

            TestCase tc = new TestCase(arr1, arr2);
            tcl.add(tc);
        }

        for(TestCase tc : tcl){
            tc.solution();
        }
    }
}
