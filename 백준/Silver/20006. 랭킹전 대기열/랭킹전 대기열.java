import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 매칭 방 없으면 새로 생성 -> -10 + 10 까지 입장가능
        // 입장하고 정원 찰때까지 대기 -> 모두 차면 시작
        // 입장가능한 방 여러개-> 가장 먼저 생성된 방에 입장
        // 플레이어 수 p , 닉 n, 레벨 L , 방 정원 m

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());// 플레이어 수
        int m = Integer.parseInt(st.nextToken());// 방원 정원
        int a=0;
        boolean[] visited=new boolean[p];

        int []l=new int[p];
        String []n= new String[p];
        for (int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());//레벨
            n[i] = st.nextToken();// 닉네임
        }

        for (int q=0;q<p;q++){
            if(!visited[q]){
                List<Integer> room = new ArrayList<>();
                room.add(q);
                visited[q]=true;
//                System.out.println("Started!");

                a=1;
                for (int i=0;i<p;i++){
                    if(a==m){
                        break;
                    }
                    if(Math.abs(l[q]-l[i])<=10&&!visited[i]){
//                        System.out.println(l[i]+" "+n[i]);
                        room.add(i);
                        visited[i]=true;
                        a++;
                    }
                }
                room.sort((o1, o2) -> n[o1].compareTo(n[o2]));
                if (room.size() == m) {
                    System.out.println("Started!");
                } else {
                    System.out.println("Waiting!");
                }
                for (int idx : room) {
                    System.out.println(l[idx] + " " + n[idx]);
                }
            }

        }

    }
}
