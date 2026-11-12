
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int N=Integer.parseInt(br.readLine());
            int[] arr=new int[N];
            StringTokenizer st= new StringTokenizer(br.readLine());
            int max=0;
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                max=Math.max(arr[i],max);
            }

            int one=0;
            int two=0;
            for(int i=0;i<N;i++){
                int diff=max-arr[i];
                if(diff==0)
                    continue;

                two+=diff/2;
                one+=diff%2;
            }
            while (two>one+1){
                two--;
                one+=2;
            }

            int result=0;
            if(one>two){
                result=one*2-1;
            }else if(two>one){
                result=two*2;
            }else {
                result=one+two;
            }
            System.out.println("#"+tc+" "+result);

        }

    }
}
/*
나무높이

첫날 키 1자라고, 둘째날 2자라고, 셋째날 1...
홀수 : +1
짝수 : +2

모든나무가 처음에 가장 키가 컷던 나무와 같아지도록  물을 안줄수도 있음!
* */