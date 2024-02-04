package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_5052 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        int N;
        String[] data;
        boolean flag;
        for (int t = 0; t < tc; t++) {

            N = Integer.parseInt(br.readLine());
            data = new String[N];
            flag = true;
            for (int i = 0; i < N; i++) {
                data[i] = br.readLine();
            }
            Arrays.sort(data);
            for (int i = 0; i < N - 1; i++) {
                if (!data[i + 1].startsWith(data[i])) continue;
                flag = false;
                break;
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
