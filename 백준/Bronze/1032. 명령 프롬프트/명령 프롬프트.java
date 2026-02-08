import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr= new String[N];
        for(int i=0;i<N;i++){
            arr[i]= br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<arr[0].length();i++){//배열 내부 길이

            int a=0;
            for (int j=0;j<N-1;j++){
                if(arr[j].charAt(i)==arr[j+1].charAt(i)){
                    a++;
                }
            }

            if(a==N-1){
                sb.append(arr[0].charAt(i));
            }
            else{
                sb.append("?");
            }
        }
        System.out.println(sb);
    }
}
