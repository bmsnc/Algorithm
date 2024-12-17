package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1749 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                data[i][j] = data[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < M + 1; i++) {
            for (int j = i; j < M + 1; j++) {
                int row, sum = 0;
                for (int k = 1; k < N + 1; k++) {
                    row = data[k][j] - data[k][i - 1];
                    sum += row;
                    if (row > sum) sum = row;
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}
