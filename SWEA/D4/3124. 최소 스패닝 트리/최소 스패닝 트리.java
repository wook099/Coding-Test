import java.util.*;
import java.io.*;

public class Solution {
	
	
	static List<int[]>[] adj;
	static boolean[] visited;
	static int V,E;
	static long sum=0;
	static int cnt=0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T =Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E= Integer.parseInt(st.nextToken());
			adj=new ArrayList[V+1];
			for(int i=1;i<=V;i++) {
				adj[i]= new ArrayList<>();
			}
			
			
			for(int i=0;i<E;i++) {
				st= new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b=  Integer.parseInt(st.nextToken());
				int c= Integer.parseInt(st.nextToken());
				
				adj[a].add(new int[]{b,c});
				adj[b].add(new int[]{a,c});

			}
			sum=0;
			cnt=0;
			
			prim();
			
			System.out.println("#"+t+" "+sum);
		}
	
	}
	
	static void prim() {
		
		boolean[] visited=new boolean[V+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		
		pq.add(new int[] {1,0});
		
	
		
		while(!pq.isEmpty()) {
			
			int[] cur=pq.poll();
			int idx=cur[0];
			int cost=cur[1];
			
			if(visited[idx]) {
				continue;
			}
			
			visited[idx]=true;
			sum+=cost;
			cnt++;
			
			if(cnt==V)
				break;
			
			for(int i=0;i<adj[idx].size();i++) {
				int[] next=adj[idx].get(i);
				
				if(!visited[next[0]]) {
					pq.add(new int[] {next[0],next[1]});
				}
			}
//			for(int i=1;i<=V;i++) {
//				if(!visited[i]&&arr[idx][i]!=Integer.MAX_VALUE) {
//					pq.add(new int[] {i,arr[idx][i]});
//				}
//			}
		}
	}
}
