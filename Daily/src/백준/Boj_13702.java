package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13702 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] data = new long[N];
        long max = -1, min = 0;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, data[i]);
        }

        int count;
        long mid;
        while(min <= max){

            mid = (min + max) / 2;
            count = 0;
            if (mid == 0) break;
            for (int i = 0; i < N; i++) {
                if (data[i] == 0) continue;
                count += (int) (data[i] / mid);
            }

            if (count < K) max = mid - 1;
            else min = mid + 1;

        }

        System.out.println(max == -1 ? 0 : max);

    }
}
