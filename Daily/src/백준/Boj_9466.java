package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9466 {
    static int[] data;
    static boolean[] v, f;
    static int count;

    static void dfs(int idx){

        if (v[idx]) return;
        v[idx] = true;

        int next = data[idx];
        if (!v[next]) dfs(next);
        else{
            if (!f[next]){
                count++;
                for (int i = next; i != idx ; i = data[i]) {
                    count++;
                }
            }
        }
        f[idx] = true;
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {

            int N = Integer.parseInt(br.readLine());
            data = new int[N + 1];
            v = new boolean[N + 1];
            f = new boolean[N + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N + 1; i++) {
                dfs(i);
            }

            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }
}
