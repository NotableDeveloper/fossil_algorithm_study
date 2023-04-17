package fossil.study.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ24508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, t, arr));
    }

    /*
        나도리가 든 바구니를 오름차순 정렬하고, 앞 쪽에 위치한 적은 수의 나도리가 든 바구니에서
        뒤에 있는 많은 수의 나도리가 든 바구니에 옮겨 담는다.
     */
    private static String solution(int n, int k, int t, int[] arr) {
        String answer = "NO";
        // empty_bucket : 나도리가 하나도 없는 바구니의 수
        int left = 0, right = n - 1, empty_bucket = 0;
        Arrays.sort(arr);


        // 앞 쪽에 위치한 바구니들 중에서 처음부터 나도리가 비어있는 바구니에 대한 처리
        while(left < n && arr[left] == 0){
            left++;
            empty_bucket++;
        }

        while(left <= right){
            // 바구니가 하나 남았다면
            if(left == right){
                /*
                    하나 남은 바구니에 나도리의 수가 k 이상이면 해당 바구니에
                    터뜨릴 수 있는 만큼의 나도리가 모인 것이다.
                 */
                if(arr[left] >= k) empty_bucket++;
                break;
            }

            // need : 제일 나도리가 많은 바구니에 옮겨줘야 할 나도리의 수
            int need = k - arr[right];

            // 옮길 수 있는 횟수보다 필요한 나도리의 수가 크면 루프 탈출
            if(t < need) break;

            // 현재 left가 need와 같다면
            if(arr[left] == need){
                t -= need;
                // right에는 필요한 나도리가 모두 옮겨졌으므로, 왼쪽으로 이동
                right--;
                // left에는 나도리가 모두 옮겨졌으므로, 오른쪽으로 이동
                left++;
                empty_bucket += 2;
            }

            // left의 나도리가 need보다 많으면
            else if(arr[left] > need){
                // left에 need 만큼 빼준다.
                arr[left] -= need;
                // 횟수도 need 만큼 차감한다.
                t -= need;
                /*
                    left에는 아직 나도리가 남아있으므로, left는 이동은 하지 않는다.
                    right는 필요한 나도리가 모두 옮겨졌으므로, 왼쪽으로 이동
                 */
                right--;
                empty_bucket++;
            }

            // left의 나도리가 need보다 적으면
            else if(arr[left] < need){
                // right에 left만큼의 나도리를 옮긴다.
                arr[right] += arr[left];
                t -= arr[left];
                /*
                    left의 모든 나도리를 옮겼으므로, 오른쪽으로 이동
                    right에는 아직 나도리가 부족하므로 이동하지 않는다.
                */
                left++;
                empty_bucket++;
            }

            // 이동 횟수가 모두 소진되면 루프 탈출
            if(t <= 0) break;
        }

        // 나도리가 비어있는 바구니가 n개 이상이면 모든 나도리를 터뜨린 것이 된다.
        if(empty_bucket >= n) answer = "YES";

        return answer;
    }
}
