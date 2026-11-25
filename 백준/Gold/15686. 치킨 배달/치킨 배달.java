import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        comb(0,1,1);
        System.out.println(result);
    }

    //빈칸 0
    //집 1
    //치킨집 2
    static void comb(int depth,int r,int c) {

        if (depth == M) {
            cal();
            return;
        }

        for (int i = r; i < N + 1; i++) {
            for (int j = c; j < N + 1; j++) {
                if (arr[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    comb(depth + 1,i,j+1);
                    visited[i][j] = false;
                }
            }
            c=1;
        }
    }

    static void cal() {
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] == 2 && visited[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int city=0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] == 1) {
                    int minDist = Integer.MAX_VALUE;

                    for (int a = 0; a < M; a++) {
                        int[] cur = list.get(a);
                        int dist = Math.abs(i - cur[0]) + Math.abs(j - cur[1]);
                        minDist = Math.min(minDist, dist);
                    }
                    city+=minDist;

                }
            }
        }
        result=Math.min(city,result);
    }

}

/*
치킨 거리 = 집과 가장 가까운 치킨집
각각의 집은 치킨거리를 가지고 있음 -> 가장 가까운치킨집과의 거리

도시의 치킨거리 = 모든 집의 치킨거리의 합

수익 증가를 위해 M개의 치킨집을 고르고 나머지는 폐업시킬거야
어떻게 골라야 도시 전체의 치킨거리가 가장 작게 될지 구해라

M개의 치킨집만 둘때 가장 최솟 거리값을 구해라

걍 조합으로 치킨집 뽑은다음에 그때의 거리값 구해서 최솟값 비교하면 끝아니냐?!!
치킨집 배열만들어서
1일때 집들 전부 순회해서 최솟값 넣어주고
2일때 넣어주고
3일때 넣어줘서
가장 최솟값 들어간애들끼리 더해서
이걸 또 최솟값

* */
