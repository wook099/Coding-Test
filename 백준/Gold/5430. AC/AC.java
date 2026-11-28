
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0;t<T;t++){
            StringBuilder sb = new StringBuilder();
            String S = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i=0;i<n;i++){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;

            for (int i=0;i< S.length();i++){

                char input =S.charAt(i);

                if (input=='R'){
                    isReverse=!isReverse;
                }else {
                    if (deque.isEmpty()){// 값없으면 끝 에러처리
                        isError=true;
                        break;
                    }else if(isReverse){//뒤로 돌아가있으면 뒤에 꺼 뺴
                        deque.pollLast();
                    }else if(!isReverse){{//앞에꺼빼
                        deque.pollFirst();
                    }}


                }
            }
            if (isError){
                sb.append("error");
            }else {

                sb.append("[");

                while (!deque.isEmpty()){
                    if (isReverse){
                        sb.append(deque.pollLast());
                    }else if(!isReverse){
                        sb.append(deque.pollFirst());
                    }

                    if (!deque.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]");
            }

            System.out.println(sb);

        }


        /*
        * 배열 or 리스트 사용시 시간초과
        * p의 길이 100,000 따라서 매번 뒤집으면 -> 100억번 연산
        * ArrayList에서 맨 앞 원소를 지우면(remove(0)) 뒤에 있는 원소들을 한 칸씩 다 앞으로 당겨야 해서 또 O(N)
        *
        * 어레이데큐를 쓰고 방향플래그를 세워 전부 빼주고 마지막에만 순서변경
        * */



    }
}
