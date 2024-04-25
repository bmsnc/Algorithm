package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15810 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        long min = Integer.MAX_VALUE;
        for (int n = 0; n < N; n++) {
            data[n] = Integer.parseInt(st.nextToken());
            min = Math.min(min, data[n]);
        }

        long left = 0;
        long right = min * M;

        while(left+1 < right) {
            long center = (left + right)/2;
            long balloon = 0;

            for (int n = 0; n < N; n++) {
                balloon += (center / data[n]);
            }

            if(balloon >= M) {
                right = center;
            }else {
                left = center;
            }
        }

        System.out.println(right);
    }
}
