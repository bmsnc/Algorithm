package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2828 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        boolean[] v = new boolean[N + 1];
        for (int i = 1; i < M + 1; i++) {
            v[i] = true;
        }

        int left = 1, right = M;
        int pos, sum = 0;
        for (int i = 0; i < K; i++) {
            pos = Integer.parseInt(br.readLine());
            if (v[pos]) continue;
            int temp;
            if (pos > right) {
                temp = pos - right;
                sum += temp;
                Arrays.fill(v, false);
                for (int j = left + temp; j < right + temp + 1; j++) {
                    v[j] = true;
                }
                left += temp;
                right += temp;
            }else if (pos < left) {
                temp = left - pos;
                sum += temp;
                Arrays.fill(v, false);
                for (int j = left - temp; j < right - temp + 1; j++) {
                    v[j] = true;
                }
                left -= temp;
                right -= temp;
            }
        }
        System.out.println(sum);
    }
}
