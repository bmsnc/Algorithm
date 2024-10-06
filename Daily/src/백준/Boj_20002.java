package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20002 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];
        int[][] d = new int[N][N];

        int sum, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                sum += data[i][j];
                d[i][j] = sum;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nx, ny;
                for (int k = 0; k < N; k++) {
                    nx = i + k;
                    ny = j + k;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    int temp = 0;
                    for (int l = i; l < nx + 1; l++) {
                        if (j - 1 < 0) temp += d[l][ny];
                        else temp += d[l][ny] - d[l][j - 1];
                    }
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);
    }
}
