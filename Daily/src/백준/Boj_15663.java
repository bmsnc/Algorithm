package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15663 {
    static int N, M;
    static List<Integer> list;
    static List<String> result;
    static StringBuilder sb;
    static boolean[] v;

    static void recursive(int idx, int[] sel){

        if (idx >= M){
            StringBuilder tmp = new StringBuilder();
            for (int i : sel) tmp.append(i).append(" ");
            if (!result.contains(tmp.toString())) result.add(tmp.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            sel[idx] = list.get(i);
            recursive(idx + 1, sel);
            v[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        recursive(0, new int[M]);
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
