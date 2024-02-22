package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14430 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] data = new int[R + 1][C + 1];
        int[][] d = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                d[i][j] = Math.max(d[i-1][j], d[i][j-1]) + data[i][j];
            }
        }

        System.out.println(d[R][C]);
    }
}
