package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10211 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {

            int N = Integer.parseInt(br.readLine());
            int[] data = new int[N + 1];
            int[] d = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < N + 1; i++) {
                d[i] = Math.max(data[i],d[i - 1] + data[i]);
                max = Math.max(max, d[i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
