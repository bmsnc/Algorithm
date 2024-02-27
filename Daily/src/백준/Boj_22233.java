package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_22233 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<String> h = new HashSet<>();
        for (int i = 0; i < N; i++) {
            h.add(br.readLine());
        }
        String[] data;
        for (int i = 0; i < K; i++) {
            data = br.readLine().split(",");
            for (int j = 0; j < data.length; j++) {
                h.remove(data[j]);
            }
            sb.append(h.size()).append("\n");
        }
        System.out.print(sb);
    }
}
