package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10709 {
    static int[][] data, d;
    static int R, C;
    static class Node{
        int x, y, time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        d = new int[R][C];

        Queue<Node> q = new LinkedList<>();
        String line;
        for (int i = 0; i < R; i++) {
            line = br.readLine();
            char t;
            Arrays.fill(d[i], - 1);
            for (int j = 0; j < C; j++) {
                t = line.charAt(j);
                if (t == 'c') {
                    q.add(new Node(i, j, 0));
                    d[i][j] = 0;
                }
            }
        }
        int x, y, time;
        Node cur;
        while (!q.isEmpty()){

            cur = q.poll();
            x = cur.x;
            y = cur.y;
            time = cur.time;
            int nx = x;
            int ny = y + 1;
            if (ny >= C) continue;
            if (d[nx][ny] == -1){
                d[nx][ny] = time + 1;
                q.add(new Node(nx, ny, time + 1));
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(d[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
