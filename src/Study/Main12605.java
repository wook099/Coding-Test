package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main12605 {
    public static void main(String[] args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String strArr[] = str.split(" ");
            Stack<String> stack = new Stack<>();

            for (String word : strArr) {
                stack.push(word);
            }

            System.out.print("Case #" + (i + 1) + ": ");

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

            System.out.println();
        }
    }
}