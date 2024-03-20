package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_25325 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> h = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        String temp;
        for (int i = 0; i < N; i++) {
            temp = st.nextToken();
            h.put(temp, 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name;
            while (st.hasMoreTokens()){
                name = st.nextToken();
                h.put(name, h.get(name) + 1);
            }
        }
        List<String> list = new ArrayList<>(h.keySet());
        Collections.sort(list, (o1, o2) -> {
            if (Objects.equals(h.get(o1), h.get(o2))) return o1.compareTo(o2);
            return Integer.compare(h.get(o2), h.get(o1));
        });
        for (String s : list) {
            sb.append(s).append(" ").append(h.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
