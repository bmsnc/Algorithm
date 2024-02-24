package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_2812 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();

        LinkedList<Integer> q = new LinkedList<>();

        q.add(num.charAt(0) - '0');
        int idx = 1, cur;
        while (idx < N && K > 0){
            cur = num.charAt(idx++) - '0';
            if (q.isEmpty()){
                q.addLast(cur);
                continue;
            }
            while (!q.isEmpty() && cur > q.peekLast()){
                q.pollLast();
                K--;
                if (K <= 0) break;
            }
            q.add(cur);
        }

        while (K-- > 0) q.pollLast();

        for (Integer integer : q) {
            sb.append(integer);
        }
        for (int i = idx; i < N; i++) {
            sb.append(num.charAt(i));
        }
        System.out.println(sb);
    }
}
