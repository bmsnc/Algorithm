package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17204 {
    static int N, K;
    static int[] data;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int next = 0;
        int count = 0;
        while (true) {
            if (v[data[next]]) break;
            v[data[next]] = true;
            count++;
            next = data[next];
            if (next == K) {
                next = -1;
                break;
            }
        }
        System.out.println(next == -1 ? count : -1);
    }
}
