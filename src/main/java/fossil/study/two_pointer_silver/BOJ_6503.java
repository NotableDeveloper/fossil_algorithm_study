package fossil.study.two_pointer_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_6503 {

    public static void main(String[] args) throws IOException {
        BOJ_6503 boj6503 = new BOJ_6503();
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        while (m != 0) {
            result.add(boj6503.solution(br.readLine(), m));
            m = Integer.parseInt(br.readLine());
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private int solution(String str, int m) {
        char[] targetStringArray = str.toCharArray();
        Map<Character, Integer> cache = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        int countOfExsistChar = 0;
        for (int i = 0; i < targetStringArray.length; i++) {
            cache.put(targetStringArray[i], 0);
        }

        while (right < targetStringArray.length) {
            if (countOfExsistChar <= m) {
                maxLength = Math.max(right - left, maxLength);
            }
            if (countOfExsistChar <= m) {
                right += 1;
                char currRightChar = targetStringArray[right - 1];
                int countOfCurrRightChar = cache.get(currRightChar);
                if (cache.get(currRightChar) == 0) {
                    countOfExsistChar += 1;
                }
                cache.put(currRightChar, countOfCurrRightChar + 1);
            } else {
                char currLeftChar = targetStringArray[left];
                Integer countOfCurrLeftChar = cache.get(currLeftChar);
                countOfCurrLeftChar -= 1;
                cache.put(currLeftChar, countOfCurrLeftChar);
                if (countOfCurrLeftChar == 0) {
                    countOfExsistChar -= 1;
                }
                left += 1;
            }
        }
        if (countOfExsistChar <= m) {
            maxLength = Math.max(right - left, maxLength);
        }

        return maxLength;
    }
}
