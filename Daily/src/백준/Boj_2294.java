package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2294 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] d = new int[K + 1];
        Arrays.fill(d, 1000001);
        d[0] = 0;
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = data[i]; j < K + 1; j++) {
                d[j] = Math.min(d[j], d[j - data[i]] + 1);
            }
        }
        System.out.println(d[K] == 1000001 ? -1 : d[K]);
    }
}
