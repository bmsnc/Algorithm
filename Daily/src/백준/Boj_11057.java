package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11057 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N + 1][10];
        Arrays.fill(data[1], 1);

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += (data[i - 1][k] % 10007);
                }
                data[i][j] = sum % 10007;
            }
        }
        int rsl = 0;
        for (int i = 0; i < 10; i++) {
            rsl += (data[N][i] % 10007);
        }
        System.out.println(rsl % 10007);
    }
}
