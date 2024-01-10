package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1166 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double start = 0.0;
        double end = Math.min(L, Math.min(W, H));

        double mid, rsl = 0.0;
        long a, b, c;
        int count = 0;

        while (start <= end){
            mid = (start + end) / 2;
            a = (long) (L / mid);
            b = (long) (W / mid);
            c = (long) (H / mid);

            if ((a * b * c) >= N) {
                rsl = Math.max(rsl, mid);
                start = mid;
            }else{
                end = mid;
            }
            if (++count > 5000) break;
        }

        System.out.println(rsl);
    }
}
