package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_2346 {
    static class Node{
        int idx, val;
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Deque<Node> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        Node next;
        int idx, val;
        while (!q.isEmpty()){

            next = q.poll();
            idx = next.idx;
            val = next.val;
            sb.append(idx + 1).append(" ");

            if (q.isEmpty()) break;
            if (val > 0){
                for (int i = 1; i < val; i++) {
                    q.add(q.poll());
                }
            }else{
                for (int i = 0; i < -val; i++) {
                    q.addFirst(q.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
