import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {//V값이 최대 2만임으로 임접행렬도 안풀림

    static int V,E,K;
//    static List<List<int[]>> adj;//.get.add 처럼 가독성이 좀 떨어짐
    static List<int[]>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        adj= new ArrayList[V+1];

        for (int i=1;i<=V;i++){
            adj[i]=new ArrayList<>();
        }

        for (int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{v,w});
        }
        dist = new int[V + 1];
        Arrays.fill(dist,INF);
        dist[K]=0;

        dijkstra();
   

        for (int i=1;i<=V;i++){
            if (dist[i]==INF){
                System.out.println("INF");
            }else {
                System.out.println(dist[i]);
            }
        }

    }
    static void dijkstra(){

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{K,0});//pq에서는 현재 위치와 가중치로 이루어짐!!!

        while (!pq.isEmpty()) {
            int[] cur= pq.poll();
            int pos=cur[0];//현위치
            int nowcost=cur[1];//그때의 가중치 합

            if (dist[pos]<nowcost)//현위치가 누적되어온 값보다 크면 걍 넘어가
                continue;

            for(int i=0;i<adj[pos].size();i++){
                int[] next = adj[pos].get(i);

                int nextpos=next[0];
                int nextcost=next[1];

                if (dist[nextpos]>nextcost+nowcost){
                    dist[nextpos]=nextcost+nowcost;

                    pq.add(new int[]{nextpos,dist[nextpos]});
                }
            }
//            for (int[] next:adj[pos]){
//                int nextpos=next[0];
//                int nextcost=next[1];
//            }
        }
    }
}
