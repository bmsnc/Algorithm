package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20055 {
    static int N, K;
    static int[] data;
    static Deque<Node> deque;
    static Deque<Node> robot;
    static class Node{
        int qIdx, dIdx;
        public Node(int qIdx, int dIdx) {
            this.qIdx = qIdx;
            this.dIdx = dIdx;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[2 * N + 1];
        deque = new ArrayDeque<>();
        robot = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 2 * N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            deque.add(new Node(i, i));
        }

        int time = 0;
        int count;
        while (true){
            time++;
            count = 0;
            rotate();
            move();
            up();
            for (int i = 1; i < 2 * N + 1; i++) {
                if (data[i] == 0) count++;
            }
            if (count >= K) break;
        }
        System.out.println(time);
    }
    static void up(){
        Node node = deque.peekFirst();
        if (data[node.dIdx] <= 0) return;
        data[node.dIdx]--;
        robot.add(new Node(1, node.dIdx));
    }

    static void rotate(){
        int dSize = deque.size();
        Node cur;
        for (int i = 0; i < dSize; i++) {
            cur = deque.poll();
            deque.add(new Node(cur.qIdx + 1 > 2 * N ? 1 : cur.qIdx + 1, cur.dIdx));
        }
        deque.addFirst(deque.pollLast());

        int rSize = robot.size();
        for (int i = 0; i < rSize; i++) {
            cur = robot.poll();
            if (cur.qIdx == N) continue;
            robot.add(new Node(cur.qIdx + 1, cur.dIdx));
        }
    }

    static void move(){

        int rSize = robot.size();
        HashSet<Integer> check = new HashSet<>();
        Node cur;
        for (int i = 0; i < rSize; i++) {
            cur = robot.poll();
            if (cur.qIdx == N) continue;
            if (data[cur.dIdx + 1 > 2 * N ? 1 : cur.dIdx + 1] > 0 && !check.contains(cur.qIdx + 1)){
                data[cur.dIdx + 1 > 2 * N ? 1 : cur.dIdx + 1]--;
                check.add(cur.qIdx + 1);
                if (cur.qIdx + 1 != N) robot.add(new Node(cur.qIdx + 1, cur.dIdx + 1 > 2 * N ? 1 : cur.dIdx + 1));
            }else{
                robot.add(cur);
                check.add(cur.qIdx);
            }
        }

    }


}
