import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<int[]>[] graph;
    static int[] vrr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        vrr=new int[N+1];

        for (int i=1;i<=N;i++){
            graph[i]= new ArrayList<>();
        }

        Arrays.fill(vrr,Integer.MAX_VALUE);

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int C=Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B,C});
            graph[B].add(new int[]{A,C});
        }


        dij();
        System.out.println(vrr[N]);
    }

    static void dij(){

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);

        vrr[1]=0;
        pq.add(new int[]{1,0});

        while (!pq.isEmpty()){

            int[] cur=pq.poll();
            int now=cur[0];
            int cost=cur[1];

            if (cost>vrr[now])
                continue;

            for (int i=0;i<graph[now].size();i++){

                int[] next = graph[now].get(i);
                int nextNode=next[0];
                int nextCost=next[1];

                if (vrr[now] + nextCost <vrr[nextNode]){
                    //현재 값+다음값이 다음 노드의 값이 되어야함
                    vrr[nextNode]=vrr[now]+nextCost;
                    pq.add(new int[]{nextNode,vrr[nextNode]});
                }
            }
        }





    }
}


/*
 * 농부 현서의 택배 배달
 * 최소한의소를 만나며 여물 줘
 *
 * N개의 헛간, 소들의 길 M개 양방향
 *
 * 길엔 C_i만큼의 소가 있음
 *
 * 1부터 N까지 이동하는 최단거라구하는 문제 -> 다익스트라
 * */











