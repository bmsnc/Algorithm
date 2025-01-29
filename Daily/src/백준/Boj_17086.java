package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17086 {
    static int R, C;
    static int[][] data, d;
    static List<Node> list;
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
    static final int INF = 1000001;
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new int[R][C];
        d = new int[R][C];
        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1) list.add(new Node(i, j));
            }
            Arrays.fill(d[i], INF);
        }
        int rsl = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] == 1) continue;
                int x,y;
                for (int k = 0; k < list.size(); k++) {
                    x = list.get(k).x;
                    y = list.get(k).y;
                    d[i][j] = Math.min(d[i][j], Math.max(Math.abs(i - x), Math.abs(j - y)));
                }
                rsl = Math.max(rsl, d[i][j]);
            }
        }
        System.out.println(rsl);
    }
}
