import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        int target=-1;
        int [] arr= new int[10];
        for (int i=0;i<10;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i=0;i<10;i++){
            sum+=arr[i];

            if(sum>=100){
                target=i;
                break;
            }
        }
        if (target == -1) {
            System.out.println(sum);
            return;
        }
        if (target==0){
            System.out.println(arr[target]);
            return;
        }

        int before = 100-(sum-arr[target]);
        int after= sum-100;

        if(before<after){
            System.out.println(sum-arr[target]);
        }else{
            System.out.println(sum);
        }
    }
}
