package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_20300 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] data = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(data);

        int end = N % 2 == 0 ? N / 2 : (N - 1) / 2;
        long max = -1;
        for (int i = 0; i < end; i++) {
            max = Math.max(max, N % 2 == 0 ? (data[i] + data[N - 1 - i]) : (data[i] + data[N - 2 - i]));
        }
        System.out.println(N % 2 == 0 ? max : Math.max(max, data[N - 1]));
    }
}
