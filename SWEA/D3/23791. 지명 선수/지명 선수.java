import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//테스트케이스




        while (T-- >0) {

            int N = Integer.parseInt(br.readLine());//배열길이
            int []A= new int[N];
            int []B= new int[N];
            boolean[] visited = new boolean[N+1];
            StringBuilder sb= new StringBuilder();
            boolean ATurn= true;
            char[] S=new char[N+1];
            int cntB=0;
            int cntA=0;

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st1.nextToken());
                B[i] = Integer.parseInt(st2.nextToken());
            }

            for (int i = 0; i < N; i++) {

                if(!ATurn){
                    while (visited[B[cntB]]) cntB++;
                    
                    visited[B[cntB]]=true;
                    S[B[cntB]]='B';
                }
                else if(ATurn){
                    while (visited[A[cntA]]) cntA++;
                        
                    
                    visited[A[cntA]]=true;
                    S[A[cntA]]='A';
                    

                }
                ATurn=!ATurn;
            }

            for (int i=0;i<S.length;i++){
                if(S[i]=='A'||S[i]=='B')
                    sb.append(S[i]);
            }
            System.out.println(sb);
        }
	}
}