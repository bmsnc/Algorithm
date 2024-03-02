package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20006 {
    static class Node implements Comparable<Node>{
        int level;
        String nickname;
        public Node(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
        @Override
        public int compareTo(Node o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<List<Node>> q = new LinkedList<>();

        int level;
        String nickname;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            level = Integer.parseInt(st.nextToken());
            nickname = st.nextToken();

            int masterLevel;
            boolean flag = false;
            for (List<Node> peek : q) {
                if (peek.size() >= K) continue;
                Node node = peek.get(0);
                masterLevel = level;
                if (masterLevel - 10 > level || masterLevel + 10 < level) continue;
                peek.add(new Node(level, nickname));
                flag = true;
                break;
            }
            if (flag) continue;
            List<Node> list = new ArrayList<>();
            list.add(new Node(level, nickname));
            q.add(list);
        }
        for (List<Node> nodes : q) {
            sb.append(nodes.size() < K ? "Waiting!" : "Started!").append("\n");
            Collections.sort(nodes);
            for (Node node : nodes) {
                sb.append(node.level).append(" ").append(node.nickname).append("\n");
            }
        }
        System.out.println(sb);
    }
}
