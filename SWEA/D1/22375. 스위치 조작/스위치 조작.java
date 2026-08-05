
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 
		 int T= Integer.parseInt(br.readLine());
		 
		 for(int t=1;t<=T;t++) {
			 
			 	
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 int N = Integer.parseInt(st.nextToken());
			 
			 st=new StringTokenizer(br.readLine());
			 int[] before= new int[N];
			 int[] after= new int[N];
			 
			 for(int i=0;i<N;i++) {
				 before[i]=Integer.parseInt(st.nextToken());
			 }
			 st=new StringTokenizer(br.readLine());
			 for(int i=0;i<N;i++) {
				 after[i]=Integer.parseInt(st.nextToken());
			 }
			 
			 int cnt=0;
			 for(int i=0;i<N;i++) {
				 
				 if(before[i]!=after[i]) {
					 
					 for(int a=i;a<N;a++) {
						 if(before[a]==1)
							 before[a]=0;
						 else
							 before[a]=1;
						 
					 }
					 cnt++;
				 }
			 }
			 
			 System.out.println("#"+t+" "+cnt);
			 
			 // 0 1 1 0 0
			 // 0 0 0 1 1
			 
			 // be af 비교해서 cnt++;
			 	
		 }
		 
		 
		 
	}
}