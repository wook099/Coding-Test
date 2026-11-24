import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());


        sb.append((1<<N)-1).append('\n');

        dfs(N,1,2,3);

        System.out.print(sb);
    }
    static void dfs(int n,int from,int temp,int to){

        if (n==1){
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        // dfs(N,1,2,3); 1번에 N개를 3번으로 옮겨라 2번은 보조이다.
        dfs(n-1,from,to,temp);// n-1를 from -> temp로 치우기 1->3  1->2

        sb.append(from).append(' ').append(to).append('\n');

        dfs(n-1,temp,from,to);// 3 1 2   3->2 3->1
    }
}
/*
큰판을 꺼내려면 작은 판을 꺼내야함
1. 작은판을 경우판 temp로 치움
2. 비워진 큰판 n번을 목표로하는 판 맨 밑에 올림

치웠던 temp 작은판뭉치를 큰판위에 쌓아야함
* */