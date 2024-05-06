package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3060 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < tc; t++) {

            N = Integer.parseInt(br.readLine());
            int day = 1;
            long sum = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++) sum += Integer.parseInt(st.nextToken());

            while(sum<=N) {
                sum *= 4;
                day++;
            }
            sb.append(day).append("\n");
        }
        System.out.println(sb);
    }
}
