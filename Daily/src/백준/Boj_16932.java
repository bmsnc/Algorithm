package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16932 {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];
        int[][] d = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q;
        HashMap<Integer, Integer> h = new HashMap<>();

        int idx = 1, size;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0 || d[i][j] > 0) continue;
                q = new LinkedList<>();
                d[i][j] = idx;
                q.add(new Node(i, j));
                size = 0;
                int x, y;
                while (!q.isEmpty()){
                    size++;
                    Node cur = q.poll();
                    x = cur.x;
                    y = cur.y;

                    int nx, ny;
                    for (int k = 0; k < 4; k++) {
                        nx = x + dx[k];
                        ny = y + dy[k];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || data[nx][ny] == 0 || d[nx][ny] > 0) continue;
                        d[nx][ny] = idx;
                        q.add(new Node(nx, ny));
                    }
                }
                h.put(idx, size);
                idx++;
            }
        }
        int rsl = -1;
        HashSet<Integer> hs;
        for (int i = 0; i < N; i++) {
            int count;
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 1) continue;
                int nx, ny;
                count = 1;
                hs = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    hs.add(d[nx][ny]);
                }
                for (Integer val : hs) {
                    count += h.getOrDefault(val, 0);
                }
                rsl = Math.max(rsl, count);
            }
        }
        System.out.println(rsl);
    }
}
