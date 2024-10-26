package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13335 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        int[] time = new int[N * W + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int cur, sum = 0;
        for (int i = 1, idx = 0; i < N * W + 1; i++) {
            cur = data[idx];
            sum += time[i];
            if (L >= sum + cur) {
                sum += cur;
                idx ++;
                if (i + W < N * W + 1) time[i + W] -= cur;
            }
            if (idx == N) {
                System.out.println(i + W);
                break;
            }
        }

    }
}
