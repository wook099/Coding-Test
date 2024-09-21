package Study;


import java.util.Stack;
import java.util.Scanner;

public class Main10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<K; i++){
            int N=sc.nextInt();

            if(N==0) {
                if(stack.empty()){
                    System.out.println("스택이 비어있음");
                }else {
                    stack.pop();
                }
            }
            else {
                stack.push(N);
            }
        }
        int sum=0;
        for(int a:stack){
            sum+=a;
        }
        System.out.println(sum);

    }
}
