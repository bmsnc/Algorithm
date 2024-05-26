package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2343 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, data[i]);
            end += data[i];
        }


        int mid, sum, count;
        while (start <= end){

            mid = (start + end) / 2;
            sum = 0;
            count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + data[i] > mid){
                    sum = 0;
                    count++;
                }
                sum += data[i];
            }
            if (sum > 0) count++;
            if (count > K){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
