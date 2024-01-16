package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11441 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        int s, e;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append(sum[e] - sum[s - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
