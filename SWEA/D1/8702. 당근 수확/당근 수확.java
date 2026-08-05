/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 
		 int T= Integer.parseInt(br.readLine());
		 
		 for(int t=1;t<=T;t++) {
			 
			 	
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 int N = Integer.parseInt(st.nextToken());
			 int []sum= new int[N];
			 int[] arr= new int[N];
			 st = new StringTokenizer(br.readLine());
			 for(int i=0;i<N;i++) {
					arr[i]=Integer.parseInt(st.nextToken());

			 }

			 
			 int idx=0;
			 for(int i=0;i<N;i++) {
				 
				 for(int j=0;j<=i;j++) {
					 sum[idx]+=arr[j];
				 }
				 idx++;
			 }
			 
			 int minIdx=0;
			 int min=0;
			 int af=0;
			 int value=0;
			 int minValue=Integer.MAX_VALUE;
			 
			 for(int i=0;i<N-1;i++) {
				 
				 af=sum[N-1]-sum[i];// 뒤에꺼 다 더한 값
				 
				 value=Math.abs(af-sum[i]);// 앞 ,뒤 차이값
				 
//				 min = Math.min(minValue, value);
				 if(minValue>value) {
					 minValue=value;
					 minIdx=i;
				 }
			 }
			 
			 System.out.println("#"+t+" "+(minIdx+1)+" "+minValue);
			 
		

	
		 }
		 
		 
		 
	}
}