package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1788 {
    static final int INF = 1000000000;
    static int recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return (recursive(n - 1) + recursive(n - 2)) % INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int rsl;
        if (N >= 0) {
            int[] data = new int[1000000 + 1];
            data[0] = 0;
            data[1] = 1;
            for (int i = 2; i <= N; i++) {
                data[i] = (data[i - 1] + data[i - 2]) % INF;
            }
            sb.append(Integer.compare(data[N], 0)).append("\n");
            sb.append(data[N]);
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            map.put(1, 1);
            int n;
            for (int i = 1; i >= N ; i--) {
                n = (map.get(i) - map.get(i - 1)) % INF;
                if (i - 2 < 0) map.put(i - 2, n);
            }
            rsl = map.get(N);
            sb.append(Integer.compare(rsl, 0)).append("\n");
            sb.append(Math.abs(rsl));
        }
        System.out.println(sb);
    }
}
