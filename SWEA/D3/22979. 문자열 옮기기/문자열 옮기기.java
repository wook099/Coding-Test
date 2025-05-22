
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {//테케 정하기

            int sum=0;

            String S = br.readLine();//문자열 받기


            int K = Integer.parseInt(br.readLine());//k 반복횟수정하기
            int A=S.length();
            if(K>0) {
                StringTokenizer st = new StringTokenizer(br.readLine());//반복횟수 입력받기

                for (int i = 0; i < K; i++) {// k개수만큼 정하기
                    sum += Integer.parseInt(st.nextToken());//반복횟수
                    sum%=A;
                }
            }
            StringBuilder sb = new StringBuilder();

                if(sum<0) {
                    for (int i=S.length()+sum;i<S.length();i++)
                        sb.append(S.charAt(i));
                    for (int i=0;i<S.length()+sum;i++){
                        sb.append(S.charAt(i));
                    }
                }
                else if(sum>0){
                    for (int i=sum;i<S.length();i++)
                        sb.append(S.charAt(i));
                    for (int i=0;i<sum;i++){
                        sb.append(S.charAt(i));
                    }
                }
                else{
                    sb.append(S);
                }



            System.out.println(sb);
        }
    }
}