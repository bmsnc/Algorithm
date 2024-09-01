package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1326 {
    static class Node {
        int cur, cnt;
        public Node(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N + 1];
        boolean[] v = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        v[start] = true;

        Node node;
        int cur, cnt, count = -1;
        while (!q.isEmpty()){
            node = q.poll();
            cur = node.cur;
            cnt = node.cnt;
            if (cur == end) {
                count = cnt;
                break;
            }
            for (int i = cur + data[cur]; i < N + 1; i += data[cur]) {
                if (v[i]) continue;
                v[i] = true;
                q.add(new Node(i, cnt + 1));
            }
            for (int i = cur - data[cur]; i > 0 ; i -= data[cur]) {
                if (v[i]) continue;
                v[i] = true;
                q.add(new Node(i, cnt + 1));
            }
        }
        System.out.println(count);
    }
}
