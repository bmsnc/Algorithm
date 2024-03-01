package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14567 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] data = new int[N + 1];
        int[] result = new int[N + 1];
        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            data[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (data[i] > 0) continue;
            result[i] = 1;
            q.add(i);
        }

        int size, depth = 1;
        while (!q.isEmpty()){
            depth++;
            size = q.size();
            int type;
            for (int i = 0; i < size; i++) {
                type = q.poll();
                int next;
                for (int j = 0; j < list[type].size(); j++) {
                    next = list[type].get(j);
                    if (--data[next] == 0){
                        q.add(next);
                        result[next] = depth;
                    }
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
