package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_22944 {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int N, H, D;
    static int[][] data;
    static boolean[][][] v;
    static Queue<Node> q;
    static class Node {
        int x, y, hp, u, time, cnt;
        public Node(int x, int y, int hp, int u, int time, int cnt) {
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.u = u;
            this.time = time;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); // 체력 
        D = Integer.parseInt(st.nextToken()); // 우산 내구도

        data = new int[N][N];
        q = new LinkedList<>();
        int count = 0;
        String line;
        char chr;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                chr = line.charAt(j);
                // 1: 시작 지점 , -1: 끝 지점 , 2: 우산
                data[i][j] = chr == 'S' ? 1 : chr == 'E' ? -1 : chr == 'U' ? 2 : 0;
                if (data[i][j] == 1) {
                    q.add(new Node(i, j, H, 0, 0, 0));
                }else if (data[i][j] == 2) count++;
            }
        }
        v = new boolean[N][N][count + 1];
        Node cur;
        int x, y, hp, u, time, cnt;
        int result = -1;
        while (!q.isEmpty()) {
            cur = q.poll();
            x = cur.x;
            y = cur.y;
            hp = cur.hp;
            u = cur.u;
            time = cur.time;
            cnt = cur.cnt;
            if (data[x][y] != 1) {
                if (data[x][y] == -1) {
                    result = time;
                    break;
                } else if (data[x][y] == 2) {
                    u = D;
                    data[x][y] = 0;
                    cnt++;
                }
                if (u > 0) u--;
                else hp --;
            } else v[x][y][cnt] = true;
            if (hp <= 0) continue;

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || v[nx][ny][cnt]) continue;
                q.add(new Node(nx, ny, hp, u, time + 1, cnt));
                v[nx][ny][cnt] = true;
            }
        }
        System.out.println(result);
    }
}
//6 2 5
//......
//......
//E..S.U
//......
//......
//......