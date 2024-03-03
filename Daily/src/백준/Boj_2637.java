package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2637 {
    static class Node{
        int idx, size;
        public Node(int idx, int size) {
            this.idx = idx;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[N + 1];
        int[] data = new int[N + 1];
        List<Integer> basic = new ArrayList<>();
        int[] d = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<Node>();
        }

        int x, y, z;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, z));
            data[y]++;
        }
        for (int i = 1; i < N + 1; i++) {
            if (list[i].isEmpty()) basic.add(i);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 1));
        d[N] = 1;
        Node cur;
        int idx, size;
        while (!q.isEmpty()){

            cur = q.poll();
            idx = cur.idx;
            size = cur.size;

            Node next;
            for (int i = 0; i < list[idx].size(); i++) {
                next = list[idx].get(i);
                d[next.idx] += d[idx] * next.size;
                if (--data[next.idx] == 0) q.add(new Node(next.idx, d[next.idx]));
            }
        }
        for (Integer i : basic) {
            sb.append(i).append(" ").append(d[i]).append("\n");
        }
        System.out.println(sb);
    }
}
