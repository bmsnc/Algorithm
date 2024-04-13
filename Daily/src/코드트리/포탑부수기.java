package 코드트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 포탑부수기 {
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
    static int N, M, K;
    static int[][] data, attackTime;
    static boolean[][] isAttacked;
    static List<Tower> towerList;

    static class Tower implements Comparable<Tower>{
        int x, y;
        public Tower(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tower{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Tower o) {
            if (data[x][y] != data[o.x][o.y]) return Integer.compare(data[x][y], data[o.x][o.y]);
            if (attackTime[x][y] != attackTime[o.x][o.y]) return Integer.compare(attackTime[o.x][o.y], attackTime[x][y]);
            if (x + y != o.x + o.y) return Integer.compare(o.x + o.y, x + y);
            return Integer.compare(o.y, y);
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        attackTime = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while (K-- > 0){
            time++;
            initList();
            if (towerList.size() <= 1) break;
            Tower attacker = towerList.get(0);
            data[attacker.x][attacker.y] += (N + M);
            attackTime[attacker.x][attacker.y] = time;
            isAttacked[attacker.x][attacker.y] = true;

            if (!attackRazor(attacker)) attackBomb(attacker, towerList.get(towerList.size() - 1));
            recover();
        }
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, data[i][j]);
            }
        }
        System.out.println(max);
    }
    static void recover(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] <= 0 || isAttacked[i][j]) continue;
                data[i][j]++;
            }
        }
    }
    static void attackBomb(Tower attacker, Tower target){

        int value = data[attacker.x][attacker.y];
        data[target.x][target.y] = Math.max(0, data[target.x][target.y] - value);
        isAttacked[target.x][target.y] = true;

        int nx, ny;
        for (int i = 0; i < 8; i++) {
            nx = (target.x + dx[i] + N) % N;
            ny = (target.y + dy[i] + M) % M;
            if (data[nx][ny] <= 0 || (nx == attacker.x && ny == attacker.y)) continue;
            data[nx][ny] = Math.max(0, data[nx][ny] - value / 2);
            isAttacked[nx][ny] = true;
        }
    }

    static boolean attackRazor(Tower attacker){

        Tower target = towerList.get(towerList.size() - 1);
        boolean[][] v = new boolean[N][M];
        int[][] backX = new int[N][M];
        int[][] backY = new int[N][M];
        boolean canAttack = false;

        Queue<Tower> q = new LinkedList<>();
        q.add(new Tower(attacker.x, attacker.y));
        v[attacker.x][attacker.y] = true;

        int x = -1, y = -1;
        Tower cur;
        while (!q.isEmpty()){

            cur = q.poll();
            x = cur.x;
            y = cur.y;
            if (x == target.x && y == target.y){
                canAttack = true;
                break;
            }

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = (x + dx[i] + N) % N;
                ny = (y + dy[i] + M) % M;

                if (v[nx][ny] || data[nx][ny] <= 0) continue;
                v[nx][ny]= true;
                q.add(new Tower(nx, ny));

                backX[nx][ny] = x;
                backY[nx][ny] = y;
            }
        }
        if (canAttack){

            data[x][y] = Math.max(0, data[x][y] - data[attacker.x][attacker.y]);
            isAttacked[x][y] = true;
            int nextX = backX[x][y];
            int nextY = backY[x][y];

            int tempX, tempY;
            while (!(nextX == attacker.x && nextY == attacker.y)){

                data[nextX][nextY] = Math.max(0, data[nextX][nextY] - data[attacker.x][attacker.y] / 2);
                isAttacked[nextX][nextY] = true;
                tempX = backX[nextX][nextY];
                tempY = backY[nextX][nextY];

                nextX = tempX;
                nextY = tempY;
            }
        }
        return canAttack;
    }

    static void initList(){
        towerList = new ArrayList<>();
        isAttacked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] <= 0) continue;
                towerList.add(new Tower(i, j));
            }
        }
        Collections.sort(towerList);
    }

}
