import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            // 1. 제로 패딩 배열 생성
            int[] paddedB = new int[M + 2 * (N - 1)];
            for (int i = 0; i < M; i++) {
                paddedB[i + (N - 1)] = B[i];
            }

            // 최댓값을 문제 범위보다 훨씬 작은 수로 설정 (-999,999)
            int maxProductSum = -999999;

            // 2. 이동하며 곱셈 수행
            for (int i = 0; i <= paddedB.length - N; i++) {
                int currentSum = 0;
                for (int j = 0; j < N; j++) {
                    currentSum += A[j] * paddedB[i + j];
                }

                // Math.max() 대신 if문으로 최댓값 갱신
                if (currentSum > maxProductSum) {
                    maxProductSum = currentSum;
                }
            }

            System.out.println("#" + tc + " " + maxProductSum);
        }

        sc.close();
    }
}
            /*
            * 두 숫자열 자유롭게 움직여 마주보는 수 곱
            * 양끝을 벗어나도 됨
            * 마주보는 숫자가 없는경우 곱셉에 포함 x
            * 서로 가장 큰 수 일때를 매칭하면 되는 문제아닐까?
            *
            * arr[n-1]xbrr[0] ~ arr[0]xbrr[n-1] 까지 전부 최대값구하기
            *
            * 구하려면 어떻게 해야할까?
            * 3 5 일때
            * 0 1 2
            *     0 1 2 3 4
            * 인경우도 고려되야함
            * 0 1 2
            *   0 1 2 3 4
            * ...
            *         0 1 2
            * 0 1 2 3 4
            * 까지 더해 최대값 구하기
            *
            * 즉 3-5= -2 부터 7까지 3+5-1
            * */