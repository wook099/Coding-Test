import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int cnt=0;
        // 1 2  3 4  5 6  7 8  9 10  11 12
        while (G!=H){
            cnt++;

            
            G=((G+1)/2);
            H=((H+1)/2);
        }
        System.out.println(cnt);
//        참가자 홀수일땐
//        마지막 번호 - 부전승
//
//        라운드마다 참가자번호 1번부터매김
//        1,2 -> 1
//        3,4 ->4
//
//        4번은 다음라운드 2번
//
//        한명만 남을떄까지 진행
//        김지민 임한수
//        몇라운드에 대결하는지 출력 (무조건 이긴다고 가정)
//
//        3개 입력
//        참가자수, 김지민, 임한수
//        N  , G != H
    }
}
