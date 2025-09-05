import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb =new StringBuilder();

        int []arr= new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int start=0;

        for (int i=0;i<N;i++){

            if (arr[i]>start){
                for (int a=start+1;a<=arr[i];a++){
                    stack.push(a);
                    sb.append("+\n");
                }
                start=arr[i];
                stack.pop();
                sb.append("-\n");
            }else if(stack.peek()!=arr[i]){
                System.out.println("NO");
                return;
            }else if(stack.peek()==arr[i]){
                stack.pop();
                sb.append("-\n");
            }


        }


            System.out.println(sb);

    }
}
