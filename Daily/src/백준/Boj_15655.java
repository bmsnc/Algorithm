package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15655 {
    static int[] data;
    static int N, K;
    static boolean[] v;
    static StringBuilder sb;

    static void recursive(int idx, int cnt, int[] sel) {
        if (cnt == K) {
            for (int i = 0; i < K; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            sel[cnt] = data[i];
            recursive(i + 1, cnt + 1, sel);
            v[i] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        recursive(0, 0, new int[K]);
        System.out.println(sb);
    }
}


