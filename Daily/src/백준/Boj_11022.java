package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11022 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int a, b;
        for (int i = 0; i < N; i++) {
            sb.append("Case #").append(i + 1).append(": ");
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}
