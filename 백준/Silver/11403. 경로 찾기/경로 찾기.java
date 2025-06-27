import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        arr = new int[T][T];

        for (int i=0;i<T;i++){//0 1 2
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<T;j++){// 0 1 2
                arr[i][j]=Integer.parseInt(st.nextToken());
            }// 0 1 -> 1 2 -> 2 0
        }



//        for (int i=0;i<T;i++){// 0 3
//            for (int j=0;j<T;j++){// 0 3
//                if(arr[i][j]==1) {
//                    for (int z = 0; z < T; z++) {
//                        if (arr[j][z] == 1)
//                            arr[i][z] = 1;
//                    }
//                }
//            }
//        }

        for (int i=0;i<T;i++){
            for (int j=0;j<T;j++){
                for (int k=0;k<T;k++){
                    if(arr[j][i]==1&&arr[i][k]==1){
                        arr[j][k]=1;
                    }
                }
            }
        }

        for (int i=0;i<T;i++){
            for (int j=0;j<T;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

}
