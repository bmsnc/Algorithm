package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1240 {
    static int N, M;
    static int[][] d;
    static final int INF = 10000001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[N + 1][N + 1];
        int s, e, dist;
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(d[i],INF);
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());

            d[s][e] = dist;
            d[e][s] = dist;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                if (i == k) continue;
                for (int j = 1; j < N + 1; j++) {
                    if (j == i) continue;
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append(d[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
