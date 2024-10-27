package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_21221 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];
        int[][] newData = new int[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                data[i][j] = line.charAt(j) == '.' ? 0 : 1;
                newData[i][j] = '.';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) continue;
                newData[i][j] = 1;
                if (i + 1 < N && data[i + 1][j] != 1) newData[i + 1][j] = 1;
                if (j + 1 < M && data[i][j + 1] != 1) newData[i][j + 1] = 1;
                if (i + 1 < N && j + 1 < M && data[i + 1][j + 1] != 1) newData[i + 1][j + 1] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(newData[i][j] == 1 ? '#' : '.');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
