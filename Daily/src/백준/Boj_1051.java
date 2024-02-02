package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1051 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                data[i][j] = line.charAt(j) - '0';
            }
        }

        int start, end, result = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                start = data[i][j];
                int diff;
                for (int k = j + 1; k < M; k++) {
                    end = data[i][k];
                    if (start != end) continue;
                    diff = k - j;
                    if (i + diff >= N) continue;
                    if (!(start == data[i + diff][j] && start == data[i + diff][k])) continue;
                    result = Math.max(result, diff);
                }
            }
        }
        System.out.println(result == -1 ? 1 : (int)Math.pow(result + 1, 2));
    }
}
