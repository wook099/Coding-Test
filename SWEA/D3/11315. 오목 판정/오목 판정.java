import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	 public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        //한 방향인게 중요함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int [] dx ={1,0,1,1};
        int [] dy= {0,1,1,-1};

        for (int t=1;t<=T;t++){

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            char[][] arr = new char[N][N];
            for (int i=0;i<N;i++){
                String s = br.readLine();
                for (int j=0;j<N;j++){
                    arr[i][j]=s.charAt(j);
                }
            }
            boolean omok=false;

            outer:
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){



                    if (arr[i][j]=='o'){

                        boolean flag = false;

                        for (int a = 0; a < 4; a++) {
                            int x=i;
                            int y=j;
                            int cnt=1;

                            while (true){
                                int nx = x + dx[a];
                                int ny = y + dy[a];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny]!='o')
                                    break;

                                if (arr[nx][ny] == 'o') {
                                    cnt++;
                                    x = nx;
                                    y = ny;
                                }

                                if (cnt >= 5) {
                                    omok = true;
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }

            if (omok){
                System.out.println("#" + t + " YES");
            } else {
                System.out.println("#" + t + " NO");
            }





        }

    }
}
