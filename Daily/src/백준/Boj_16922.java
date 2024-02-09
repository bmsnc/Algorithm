package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16922 {
    static boolean[][] v;
    static int[] data = {1, 5, 10, 50};
    static int N, result;
    static void recursive(int k, int sum){

        if (v[k][sum]) return;
        v[k][sum] = true;
        if (k >= N) {
            result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            recursive(k + 1, sum + data[i]);
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        v = new boolean[N + 1][50 * N + 1];

        result = 0;
        recursive(0, 0);

        System.out.println(result);
    }

}
