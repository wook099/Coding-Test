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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{    static int N;
    static int max;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=1;t<=T;t++){

            N = Integer.parseInt(br.readLine());
            list= new ArrayList<>();
            StringTokenizer st=  new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            /*
            * 0<i<size-1 양 옆다 있는 경우: list.get(i-1) * list.get(i+1
            * 한쪽만 있는 경우: +맨뒤, 맨앞
            * 혼자 남은 경우: +자기자신
            *
            * 블록을 제거하면 양옆으로 밀착이 되어야함 -> 배열 x , 배열리스트 필요 재정렬 자동으로 해줌!
            * 배열로 하게되면 해당 자리에 0이나 -1로 두고 이웃을 탐색시 0,-1이아닌 다음 숫자를 찾는 별도 로직이 필요
            *
            * dfs로 경우의 수를 판단해서 백트래킹해 원상복구 과정이필요함
            * list.remove, list.add 과정을 하면 됨
            * */

            max=0;
            dfs(list,0);

            System.out.println("#" + t + " "+max);
        }
    }
    static void dfs(List<Integer> list,int score){

        if(list.isEmpty()){
            max=Math.max(max,score);
            return;
        }

        int size= list.size();
        int sum=0;

        for (int i=0;i<size;i++){

            if (0<i&&i<size-1){
                sum=list.get(i-1)*list.get(i+1);
            } else if(size==1){
                sum=list.get(0);
            }else if (i==size-1){
                sum=list.get(size-2);
            } else if(i==0){
                sum=list.get(1);
            }

            int remove=list.remove(i);
            dfs(list,score+sum);
            list.add(i,remove);
        }


    }
}
