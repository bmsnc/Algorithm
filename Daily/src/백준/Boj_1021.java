package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1021 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        int findIdx, count = 0;
        for (int i = 0; i < K; i++) {

            findIdx = q.indexOf(data[i]);
            if (findIdx <= q.size() / 2){
                while (q.getFirst() != data[i]){
                    q.addLast(q.pollFirst());
                    count++;
                }
            }else{
                while (q.getFirst() != data[i]){
                    q.addFirst(q.pollLast());
                    count++;
                }
            }
            q.pollFirst();
        }
        System.out.println(count);
    }
}
