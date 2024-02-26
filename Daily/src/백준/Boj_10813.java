package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10813 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            data[i] = i;
        }

        int s, e, temp;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            temp = data[s];
            data[s] = data[e];
            data[e] = temp;
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb);
    }
}
