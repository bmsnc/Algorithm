package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2565 {
    static class Node {
        int start, end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b));
        }
        list.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        int[] d = new int[N];
        int max = -1;
        for (int i = 0; i < N; i++) {
           d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(j).end < list.get(i).end && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(N - max);
    }
}
