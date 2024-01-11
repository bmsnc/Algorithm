package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18352 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[N + 1];
        boolean[] v = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list[s].add(e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;

        int cur, count = 0;
        List<Integer> rsl = new ArrayList<>();

        int size;
        while (!q.isEmpty()){

            size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                cur = q.poll();
                int next;
                for (int j = 0; j < list[cur].size(); j++) {
                    next = list[cur].get(j);
                    if (v[next]) continue;
                    v[next] = true;
                    q.add(next);
                    if (count == K) rsl.add(next);
                }
            }
        }
        Collections.sort(rsl);
        if (rsl.isEmpty()) System.out.println(-1);
        else{
            for (int i = 0; i < rsl.size(); i++) {
                sb.append(rsl.get(i)).append("\n");
            }
            System.out.println(sb);
        }
    }
}
