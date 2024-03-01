package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2910 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st=  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> original = new ArrayList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int idx;
        for (int i = 0; i < N; i++) {
            idx = Integer.parseInt(st.nextToken());
            list.add(idx);
            original.add(idx);
            h.put(idx, h.getOrDefault(idx, 0) + 1);
        }
        Collections.sort(list, (o1, o2) -> {
            if (h.get(o1) == h.get(o2)) {
                return original.indexOf(o1) - original.indexOf(o2);
            } else {
                return Integer.compare(h.get(o2), h.get(o1));
            }
        });
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
