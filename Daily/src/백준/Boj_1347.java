package 백준;

import java.util.*;
import java.io.*;

public class Boj_1347 {
    static int maxLenX = 50;
    static int maxLenY = 50;
    static int minLenX = 50;
    static int minLenY = 50;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node {
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[][] v = new boolean[101][101];
        int N = Integer.parseInt(st.nextToken());
        String line = br.readLine();

        String chr;
        int x = 50, y = 50, d = 0;
        v[x][y] = true;
        for (int i = 0; i < line.length(); i++) {
            chr = line.substring(i, i + 1);
            if (chr.equals("F")) {
                x += dx[d];
                y += dy[d];

                maxLenX = Math.max(maxLenX, x);
                maxLenY = Math.max(maxLenY, y);
                minLenX = Math.min(minLenX, x);
                minLenY = Math.min(minLenY, y);
                v[x][y] = true;
            } else if (chr.equals("R")) {
                d -= 1;
                if (d < 0) d += 4;
            } else if (chr.equals("L")) {
                d += 1;
                if (d > 3) d -= 4;
            }
        }
        for (int i = minLenX; i < maxLenX + 1; i++) {
            for (int j = minLenY; j < maxLenY + 1; j++) {
                sb.append(v[i][j] ? "." : "#");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
