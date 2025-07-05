import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//4
        int M = Integer.parseInt(st.nextToken());//2
        int[] pack = new int[M];
        int[] one = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i]= Integer.parseInt(st.nextToken());//12 3, 15 4
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);
        Arrays.sort(one);
        int sum=0;

        if(pack[0]>=one[0]*6){
            sum=one[0]*N;

        }
        else {
            int A = N/6;
            int B = N%6;
            if(pack[0]>B*one[0]){
                sum=pack[0]*A+one[0]*B;
            }
            else {
                sum=pack[0]*(A+1);
            }

        }
        System.out.println(sum);

    }
}//끊어진 기타줄 개수 N 브랜듣ㄷ 개수 m
//  4 2  패키지 6개 가격12  낱개 1개 가격 3
// 최소 가격이닌