package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1380 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true){
            count++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            String[] data = new String[N];
            int[] check = new int[N];
            for (int i = 0; i < N; i++) {
                data[i] = br.readLine();
            }
            int tmp;
            for (int i = 0; i < 2*N -1; i++) {
                st = new StringTokenizer(br.readLine());
                tmp = Integer.parseInt(st.nextToken());
                check[tmp - 1]++;
            }
            for (int i = 0; i < N; i++) {
                if (check[i] % 2 != 0){
                    sb.append(count).append(" ").append(data[i]).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

