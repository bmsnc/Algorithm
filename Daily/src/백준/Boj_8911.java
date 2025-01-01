package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_8911 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // L : -1, R: + 1
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String line;

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            char c;
            int nowX = 0, nowY = 0, dir = 0;
            int minX = 0, minY = 0;
            int maxX = 0, maxY = 0;
            for (int j = 0; j < line.length(); j++) {
                c = line.charAt(j);
                if (c == 'F') {
                    nowX = nowX + dx[dir];
                    nowY = nowY + dy[dir];
                } else if (c == 'B') {
                    nowX = nowX - dx[dir];
                    nowY = nowY - dy[dir];
                } else if (c == 'L') {
                    if (dir == 0)
                        dir = 3;
                    else
                        dir--;
                } else if (c == 'R') {
                    if (dir == 3)
                        dir = 0;
                    else
                        dir++;
                }
                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            int rsl = (maxX - minX) * (maxY - minY);
            sb.append(rsl).append("\n");

        }
        System.out.println(sb);
    }
}
