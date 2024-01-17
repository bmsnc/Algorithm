package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1743 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] data = new int[R + 1][C + 1];
        boolean[][] v = new boolean[R + 1][C + 1];

        int r, c;
        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            data[r][c] = 1;
        }

        Queue<Node> q;
        int result = -1;
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (data[i][j] == 0 || v[i][j]) continue;

                q = new LinkedList<>();
                q.add(new Node(i, j));
                v[i][j] = true;

                Node temp;
                int x, y;
                int size = 0;
                while (!q.isEmpty()){

                    temp = q.poll();
                    size++;

                    x = temp.x;
                    y = temp.y;

                    int nx, ny;
                    for (int k = 0; k < 4; k++) {

                        nx = x + dx[k];
                        ny = y + dy[k];
                        if (nx < 1 || nx >= R + 1 || ny < 1 || ny >= C + 1 || v[nx][ny] || data[nx][ny] == 0) continue;

                        v[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
                result = Math.max(result, size);
            }
        }
        System.out.println(result);
    }
}
