package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_10431 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {

            st = new StringTokenizer(br.readLine());
            st.nextToken();

            LinkedList<Integer> q = new LinkedList<>();
            int count = 0, cur;
            for (int i = 0; i < 20; i++) {
                cur = Integer.parseInt(st.nextToken());
                if (q.isEmpty()) {
                    q.addFirst(cur);
                    continue;
                }
                boolean flag = true;
                int idx = -1;
                for (int j = 0; j < q.size(); j++) {
                    if (q.get(j) > cur){
                        idx = j;
                        flag = false;
                        break;
                    }
                }

                if (flag) q.addLast(cur);
                else {
                    count += (q.size() - idx);
                    q.add(idx, cur);
                }
            }
            sb.append(t + 1).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
