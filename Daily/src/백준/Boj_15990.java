package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15990 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] data = new long[100001][4];
        data[1][1] = 1;
        data[2][2] = 1;
        data[3][1] = 1;
        data[3][2] = 1;
        data[3][3] = 1;
        for (int i = 4; i < 100001; i++) {
            data[i][1] = (data[i-1][2] + data[i-1][3]) % 1000000009;
            data[i][2] = (data[i-2][1] + data[i-2][3]) % 1000000009;
            data[i][3] = (data[i-3][1] + data[i-3][2]) % 1000000009;
        }

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append((data[N][1] + data[N][2] + data[N][3]) % 1000000009).append("\n");
        }
        System.out.println(sb);
    }
}
