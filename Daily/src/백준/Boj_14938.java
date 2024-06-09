package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14938 {
    static class Node{
        int end, dis;
        public Node(int end, int dis) {
            this.end = end;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        final int INF = 1000001;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] item = new int[N + 1];
        int[][] dis = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }

        int s, e, d;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            dis[s][e] = d;
            dis[e][s] = d;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                if (i == k) continue;
                for (int j = 1; j < N + 1; j++) {
                    if (i == j) continue;
                    if (dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        int count = 0, temp;
        for (int i = 1; i < N + 1; i++) {
            temp = 0;
            for (int j = 1; j < N + 1; j++) {
                if (dis[i][j] > K) continue;
                temp += item[j];
            }
            count = Math.max(count, temp);
        }
        System.out.println(count);
    }
}