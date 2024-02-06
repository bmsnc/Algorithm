package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
    static int N, max;
    static int[][] data;
    static boolean[] v;

    static void recursive(int k, int idx){

        if (k == N / 2){
            int teamA = 0, teamB = 0;
            boolean flag;
            for (int i = 1; i < N + 1; i++) {
                flag = v[i];
                for (int j = 1; j < N + 1; j++) {
                    if (i == j) continue;
                    if (flag && v[j]) teamA += data[i][j];
                    else if (!flag && !v[j]) teamB += data[i][j];
                }
            }
            max = Math.min(max, Math.abs(teamA - teamB));
            return;
        }

        for (int i = idx; i < N + 1; i++) {
            if (v[i]) continue;
            v[i] = true;
            recursive(k + 1, i + 1);
            v[i] = false;
        }
    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N + 1][N + 1];
        v = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MAX_VALUE;
        recursive(0, 1);

        System.out.println(max);
    }
}
