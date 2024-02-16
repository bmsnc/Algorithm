package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11663 {
    static int find(int x, int n, int[] data){

        int start = 0, end = n, mid;
        if (data[n - 1] < x) return n;
        if (data[0] > x) return 0;
        while (start <= end){
            mid = (start + end) / 2;

            if (x <= data[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return start;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        int s,e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append(find(e + 1, N, data) - find(s, N, data)).append("\n");
        }
        System.out.println(sb);
    }
}
