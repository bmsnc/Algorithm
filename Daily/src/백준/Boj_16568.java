package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16568 {
    static class Node{
        int idx, time;
        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        for(int i = 1; i <= N ; i++){
            dp[i] = dp[i-1] + 1;
            if(i-a-1 >= 0 ){
                dp[i] = Math.min(dp[i],dp[i-a-1]+1);
            }
            if(i-b-1 >= 0 ){
                dp[i] = Math.min(dp[i],dp[i-b-1]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
