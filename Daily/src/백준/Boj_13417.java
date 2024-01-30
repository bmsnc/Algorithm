package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Boj_13417 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        int N;
        Deque<String> q;
        List<String> list;
        for (int i = 0; i < tc; i++) {

            N = Integer.parseInt(br.readLine());
            q = new ArrayDeque<>();
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(st.nextToken());
            }
            q.add(list.get(0));
            String first;
            for (int j = 1; j < N; j++) {
                first = q.peekFirst();
                if (first.charAt(0) >= list.get(j).charAt(0)){
                    q.addFirst(list.get(j));
                }else{
                    q.addLast(list.get(j));
                }
            }
            while (!q.isEmpty()){
                sb.append(q.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
