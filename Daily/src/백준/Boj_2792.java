package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2792 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[M];
        int start = 1, end = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            data[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, data[i]);
        }

        int mid;
        while (start <= end){

            mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += data[i] / mid;
                if (data[i] % mid > 0) sum++;
            }

            if (sum > N){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
