package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5883 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int val, start, count, rsl = 1;
        for (int i = 0; i < N; i++) {
            val = data[i];
            count = 1;
            start = -1;
            for (int j = 0; j < N; j++) {
                if (val == data[j]) continue;
                if (start == -1){
                    start = data[j];
                    continue;
                }
                if (start == data[j]) {
                    count++;
                    rsl = Math.max(rsl, count);
                    continue;
                }
                start = data[j];
                count = 1;
            }
        }
        System.out.println(rsl);
    }
}
