package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int VALUE = 10000001;

        int[][] data = new int[N + 1][M + 1];
        int[][] d = new int[N + 1][M + 1];
        String line;
        for (int i = 1; i < N + 1; i++) {
            line = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                data[i][j] = line.charAt(j - 1) - '0';
            }
            Arrays.fill(d[i], VALUE);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1));
        d[1][1] = 1;

        int x, y;
        Node cur;
        while (!q.isEmpty()){

            cur = q.poll();
            x = cur.x;
            y = cur.y;

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= M + 1 || data[nx][ny] == 0) continue;
                if (d[nx][ny] > d[x][y] + 1){
                    q.add(new Node(nx, ny));
                    d[nx][ny] = d[x][y] + 1;
                }
            }
        }

        System.out.println(d[N][M]);
    }
}
