package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            data[i] -= B;
            sum++;
            if (data[i] <= 0) continue;
            sum += data[i] / C;
            if (data[i] % C > 0) sum++;
        }
        System.out.println(sum);
    }
}
