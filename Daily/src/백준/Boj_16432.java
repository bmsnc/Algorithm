package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16432 {
    static List<Integer>[] list;
    static int N;
    static boolean flag;
    static StringBuilder sb;
    static boolean[][] v;
    static void dfs(int idx, int before, String result){
        if (flag) return;
        if (idx == N){
            flag = true;
            for (int i = 0; i < N; i++) {
                sb.append(result.charAt(i)).append("\n");
            }
            return;
        }

        int next;
        for (int i = 0; i < list[idx].size(); i++) {
            next = list[idx].get(i);
            if (next == before || v[idx][next]) continue;
            v[idx][next] = true;
            dfs(idx + 1, next, result + next);
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        list = new List[N];
        v = new boolean[N][10];


        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        int K;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        flag = false;
        dfs(0, 0, "");

        System.out.println(flag ? sb : -1);
    }
}
