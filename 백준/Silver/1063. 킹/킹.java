
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kX = kingPos.charAt(0) - 'A' + 1;
        int kY = kingPos.charAt(1) - '0';
        int sX = stonePos.charAt(0) - 'A' + 1;
        int sY = stonePos.charAt(1) - '0';



        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            int dx = 0;
            int dy = 0;

            switch (cmd) {
                case "R":  dx = 1;  dy = 0;  break;
                case "L":  dx = -1; dy = 0;  break;
                case "B":  dx = 0;  dy = -1; break;
                case "T":  dx = 0;  dy = 1;  break;
                case "RT": dx = 1;  dy = 1;  break;
                case "LT": dx = -1; dy = 1;  break;
                case "RB": dx = 1;  dy = -1; break;
                case "LB": dx = -1; dy = -1; break;
            }

            int nkX = kX + dx;
            int nkY = kY + dy;
            if (nkX >= 1 && nkX <= 8 && nkY >= 1 && nkY <= 8) {
                if (nkX == sX && nkY == sY) {
                    int nsX = sX + dx;
                    int nsY = sY + dy;

                    if (nsX >= 1 && nsX <= 8 && nsY >= 1 && nsY <= 8) {
                        kX = nkX;
                        kY = nkY;
                        sX = nsX;
                        sY = nsY;
                    }
                } else {
                    kX = nkX;
                    kY = nkY;
                }
            }
        }

        System.out.println((char)(kX + 'A' - 1) + "" + kY);
        System.out.println((char)(sX + 'A' - 1) + "" + sY);
    }
}
