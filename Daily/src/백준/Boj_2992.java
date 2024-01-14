package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Boj_2992 {
    static List<Integer> list;
    static int N;
    static int rsl;
    static boolean[] v;

    static void recursive(int idx, String val){

        if (idx == list.size()){
            if (val.charAt(0) == '0') return;
            int cur = Integer.parseInt(val);
            if (cur <= N) return;
            rsl = Math.min(rsl, cur);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (v[i]) continue;
            v[i] = true;
            recursive(idx + 1, val + list.get(i));
            v[i] = false;
        }

    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        int temp = N;
        while (temp > 0){
            list.add(temp % 10);
            temp /= 10;
        }
        v = new boolean[list.size()];
        rsl = Integer.MAX_VALUE;
        recursive(0, "");

        System.out.println(rsl == Integer.MAX_VALUE ? 0 : rsl);
    }
}
