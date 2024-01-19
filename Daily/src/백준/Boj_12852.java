package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_12852 {
    static class Node{
        int cur, count;
        String path;
        public Node(int cur, int count, String path) {
            this.cur = cur;
            this.count = count;
            this.path = path;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N + 1];
        Arrays.fill(data, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        q.add(new Node(N, 0, N + " "));
        data[N] = 0;

        Node temp = null;
        int cur, count;
        String path;
        while (!q.isEmpty()){

            temp = q.poll();
            cur = temp.cur;
            count = temp.count;
            path = temp.path;

            if (cur == 1){
                sb.append(count).append("\n");
                sb.append(path);
                break;
            }

            if (cur % 3 == 0 && cur / 3 > 0 && data[cur % 3] > data[cur] + 1){
                data[cur / 3] = data[cur] + 1;
                q.add(new Node(cur / 3, count + 1, path + (cur / 3) + " "));
            }
            if (cur % 2 == 0 && cur / 2 > 0 && data[cur % 2] > data[cur] + 1){
                data[cur / 2] = data[cur] + 1;
                q.add(new Node(cur / 2, count + 1, path + (cur / 2) + " "));
            }
            if (cur - 1 > 0 && data[cur - 1] > data[cur] + 1){
                data[cur - 1] = data[cur] + 1;
                q.add(new Node(cur - 1, count + 1, path + (cur - 1) + " "));
            }
        }
        System.out.println(sb);
    }
}
