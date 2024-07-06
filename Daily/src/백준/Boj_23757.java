package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_23757 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int val;
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            val = Integer.parseInt(st.nextToken());
            if (pq.isEmpty()) {
                flag = false;
                break;
            }
            int poll = pq.poll();
            if (val > poll) {
                flag = false;
                break;
            }
            if (poll - val == 0) continue;
            pq.add(poll - val);
        }

        System.out.println(flag ? 1 : 0);
    }
}
