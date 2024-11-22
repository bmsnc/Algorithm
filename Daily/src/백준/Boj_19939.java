package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19939 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rsl = 0;
        for (int i = 1; i < K + 1; i++) {
            rsl += i;
        }

        if (N < rsl) sb.append(-1);
        else {
            if ((N-rsl) % K == 0) sb.append(K - 1);
            else sb.append(K);
        }
        System.out.println(sb);
    }
}
