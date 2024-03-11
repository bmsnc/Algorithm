package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1495 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] d = new int[M + 1];
        Arrays.fill(d, -1);
        st = new StringTokenizer(br.readLine());
        int vol;
        d[S] = 0;
        List<Integer> list;
        for (int i = 1; i < N + 1; i++) {
            vol = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int j = 0; j < M + 1; j++) {
                if (d[j] == i - 1){
                    int plus = j + vol;
                    int minus = j - vol;

                    if (plus >= 0 && plus < M + 1){
                        list.add(plus);
                    }
                    if (minus >= 0 && minus < M + 1){
                        list.add(minus);
                    }
                }
            }
            for (Integer val : list) {
                d[val] = i;
            }
        }
        int rsl = -1;
        for (int i = 0; i < M + 1; i++) {
            if (d[i] != N) continue;
            rsl = Math.max(rsl, i);
        }
        System.out.println(rsl);
    }
}
