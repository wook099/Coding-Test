
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception{
	
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            int maxDistance = 0;

            // 두 가지 시나리오: ?를 모두 R 또는 모두 L
            for (int dir = -1; dir <= 1; dir += 2) { // dir = -1 (L), 1 (R)
                int pos = 0;
                int tempMax = 0;

                for (char c : s.toCharArray()) {
                    if (c == 'L') pos -= 1;
                    else if (c == 'R') pos += 1;
                    else if (c == '?') pos += dir;

                    tempMax = Math.max(tempMax, Math.abs(pos));
                }

                maxDistance = Math.max(maxDistance, tempMax);
            }

            System.out.println(maxDistance);
        }
	}
}