package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2668 {
    static int[] data;
    static int N;
    static boolean[] v;
    static List<Integer> list;
    static void recursive(int idx, int start){

        if (!v[data[idx]]){
            v[data[idx]] = true;
            recursive(data[idx], start);
            v[data[idx]] = false;
        }
        if (data[idx] == start) list.add(start);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        data = new int[N + 1];
        v = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; i++) {
            v[i] = true;
            recursive(i, i);
            v[i] = false;
        }

        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
