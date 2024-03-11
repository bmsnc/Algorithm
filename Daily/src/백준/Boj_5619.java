package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_5619 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);
        int[] ans = new int[6];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (count == 6) break;
                ans[count++] = Integer.parseInt(data[i]+""+data[j]);
                ans[count++] = Integer.parseInt(data[j]+""+data[i]);
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[2]);
    }
}
