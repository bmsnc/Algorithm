package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18353 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N + 1];
        int[] d = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int result = -1;
        for (int i = 1; i < N + 1; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (data[j] > data[i]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            result = Math.max(result, d[i]);
        }

        System.out.println(N - result);
    }
}
