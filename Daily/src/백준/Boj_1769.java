package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1769 {
    static int count = 0;
    static int rsl = -1;
    static void recursive(String N) {
        if(N.length() > 1) count++;
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum += N.charAt(i) - '0';
        }
        if (sum < 10) {
            rsl = sum;
            return;
        }
        recursive(sum+"");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        recursive(N);
        sb.append(count).append("\n");
        sb.append(rsl % 3 == 0 ? "YES" : "NO");

        System.out.println(sb);
    }
}
