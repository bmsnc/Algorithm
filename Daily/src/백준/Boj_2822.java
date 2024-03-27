package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2822 {
    static class Node{
        int idx, score;
        public Node(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Node(i + 1, Integer.parseInt(br.readLine())));
        }
        list.sort((o1, o2) -> Integer.compare(o2.score, o1.score));
        List<Node> result = list.subList(0, 5);
        result.sort((o1, o2) -> Integer.compare(o1.idx, o2.idx));
        int sum = 0;
        for (Node node : result) {
            sum += node.score;
            sb.append(node.idx).append(" ");
        }
        System.out.println(sum);
        System.out.println(sb);

    }
}
