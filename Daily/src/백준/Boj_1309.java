package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1309 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N + 1];
        d[0] = 1;
        d[1] = 3;
        for (int i = 2; i < N + 1; i++) {
            d[i] = (d[i - 2] + d[i - 1] * 2) % 9901;
        }
        System.out.println(d[N]);
    }
}
