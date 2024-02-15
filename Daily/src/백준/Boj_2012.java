package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 그리디
public class Boj_2012 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        long sum = 0;
        int start = 1;
        for (Integer value : list) {
            sum += Math.abs(start - value);
            start++;
        }

        System.out.println(sum);
    }
}
