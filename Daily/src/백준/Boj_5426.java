package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        String line;
        int len, N;
        String[][] data;
        for (int t = 0; t < tc; t++) {
            line = br.readLine();
            len = line.length();
            N = (int) Math.pow(len, 0.5);
            data = new String[N][N];
            for (int i = 0; i < N * N; i++) {
                data[i / N][i % N] = line.charAt(i) + "";
            }
            for (int i = N - 1; i > -1; i--) {
                for (int j = 0; j < N; j++) {
                    sb.append(data[j][i]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
