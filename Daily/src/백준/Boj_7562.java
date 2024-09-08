package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7562 {
    static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    static class Node {
        int x, y, count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int N, x, y, r, c;
        int[][] data;
        boolean[][] v;
        Queue<Node> q;
        for (int t = 0; t < tc; t++) {

            N = Integer.parseInt(br.readLine());
            data = new int[N][N];
            v = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.add(new Node(x, y, 0));
            v[x][y] = true;

            Node cur;
            int cx, cy;
            while (!q.isEmpty()) {

                cur = q.poll();
                cx = cur.x;
                cy = cur.y;
                if (cx == r && cy == c) {
                    sb.append(cur.count).append("\n");
                    break;
                }

                int nx, ny;
                for (int i = 0; i < 8; i++) {
                    nx = cx + dx[i];
                    ny = cy + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || v[nx][ny]) continue;
                    v[nx][ny] = true;
                    q.add(new Node(nx, ny, cur.count + 1));
                }
            }
        }
        System.out.println(sb);
    }
}
