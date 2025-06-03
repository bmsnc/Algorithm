package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10157 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] data = new int[R][C];
        int K = Integer.parseInt(br.readLine());

        if (K > R * C) sb.append(0);
        else {
            int cur = 1, d = 0;
            int x = 0, y = 0;
            int nx, ny;
            while (cur <= R*C && cur <= K) {
                if (cur == K) sb.append(y+1).append(" ").append(x+1);
                data[x][y] = cur++;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || data[nx][ny] > 0) {
                    d++;
                    d %= 4;
                }
                x += dx[d];
                y += dy[d];
            }
        }
        System.out.println(sb);
    }
}
