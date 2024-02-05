package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1138 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N];
        Arrays.fill(data, -1);
        int pos, count;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pos = Integer.parseInt(st.nextToken());
            count = 0;
            for (int j = 0; j < N; j++) {
                if (data[j] != -1) continue;
                if (count == pos) data[j] = i + 1;
                count++;
            }
        }
        for (int idx : data) {
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}
