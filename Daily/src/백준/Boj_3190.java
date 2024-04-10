package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] data;
    static Deque<Node> deque;
    static class Node{
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        data = new int[N][N];
        int[] time = new int[10001];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            data[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            time[Integer.parseInt(st.nextToken())] = st.nextToken().equals("L") ? 1 : 2;
        }

        Queue<Node> q = new LinkedList<>();
        deque = new ArrayDeque<>();
        q.add(new Node(0, 0 ,0));
        data[0][0] = 1;
        deque.add(new Node(0, 0));
        int x, y, d, pass = 0, nx, ny;
        Node cur;
        while (!q.isEmpty()){
            cur = q.poll();
            x = cur.x;
            y = cur.y;
            d = cur.d;

            if (time[pass] > 0){
                if (time[pass] == 1){
                    d--;
                    if (d < 0) d += 4;
                }else{
                    d++;
                    if (d > 3) d -= 4;
                }
            }
            pass++;
            nx = x + dx[d];
            ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || data[nx][ny] == 1) break;

            if (data[nx][ny] != -1) {
                Node last = deque.pollLast();
                data[last.x][last.y] = 0;
            }

            deque.addFirst(new Node(nx, ny));
            data[nx][ny] = 1;

            q.add(new Node(nx, ny, d));
        }
        System.out.println(pass);
    }
}
