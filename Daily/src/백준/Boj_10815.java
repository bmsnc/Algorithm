package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_10815 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[20000001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            v[Integer.parseInt(st.nextToken()) + 10000000] = true;
        }
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sb.append(v[Integer.parseInt(st.nextToken()) + 10000000] ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}
