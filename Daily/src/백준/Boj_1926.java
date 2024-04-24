package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1926 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] v = new boolean[N][M];
        Queue<Node> q;
        int count = 0, max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] || data[i][j] == 0) continue;
                v[i][j] = true;

                q = new LinkedList<>();
                int temp = 0;
                count++;
                q.add(new Node(i, j));

                Node cur;
                int x, y;
                while (!q.isEmpty()){
                    temp++;
                    cur = q.poll();
                    x = cur.x;
                    y = cur.y;

                    int nx, ny;
                    for (int k = 0; k < 4; k++) {
                        nx = x + dx[k];
                        ny = y + dy[k];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny] || data[nx][ny] == 0) continue;
                        v[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
                max = Math.max(max, temp);
            }
        }
        sb.append(count).append("\n");
        sb.append(max);

        System.out.println(sb);
    }
}
