package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19637 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        String[][] data = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            data[i][0] = st.nextToken();
            data[i][1] = st.nextToken();
        }

        int val, start, end;
        for (int i = 0; i < K; i++) {

            val = Integer.parseInt(br.readLine());
            start = 0;
            end = N - 1;

            int midIdx, mid;
            while (start <= end){

                midIdx = (start + end) / 2;
                mid = Integer.parseInt(data[midIdx][1]);

                if (val > mid){
                    start = midIdx + 1;
                }else{
                    end = midIdx - 1;
                }
            }
            sb.append(data[start][0]).append("\n");
        }
        System.out.println(sb);
    }
}
