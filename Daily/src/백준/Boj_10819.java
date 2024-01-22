package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10819 {
    static int[] data;
    static int N, max;
    static boolean[] v;

    static void recursive(int idx, int[] sel){

        if (idx == N){
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(sel[i] - sel[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            sel[idx] = data[i];
            recursive(idx + 1, sel);
            v[i] = false;
        }


    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        v = new boolean[N];
        data = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        max = -1;
        recursive(0, new int[N]);

        System.out.println(max);
    }
}
