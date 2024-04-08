package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14888 {
    static int[] data;
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static List<Character> list;
    static boolean[] v;
    static Character[] operator = {'+', '-', '*', '/'};

    static void recursive(int idx, int rsl){

        if (idx >= N){
            max = Math.max(max, rsl);
            min = Math.min(min, rsl);
            return;
        }

        char temp;
        int value, next;
        for (int i = 0; i < list.size(); i++) {
            if (v[i]) continue;
            v[i] = true;
            temp = list.get(i);
            value = data[idx];

            if (temp == '+') next = rsl + value;
            else if (temp == '-') next = rsl - value;
            else if (temp == '*') next = rsl * value;
            else next = rsl / value;
            recursive(idx + 1, next);
            v[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int cnt;
        for (int i = 0; i < 4; i++) {
            cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                list.add(operator[i]);
            }
        }
        v = new boolean[list.size()];
        recursive(1, data[0]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);

    }
}
