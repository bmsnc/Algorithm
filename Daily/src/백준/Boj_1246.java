package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1246 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);
        int value = -1, max = -1;
        int tmp;
        for (int i = Math.max(0, N - K); i < N; i++) {
            tmp = data[i] * (N - i);
            if (max < tmp){
                max = tmp;
                value = data[i];
            }
        }
        System.out.println(value + " " + max);
    }
}
