package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13414 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> h = new HashMap<>();
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            h.put(line, i + 1);
        }

        List<String> list = new ArrayList<>(h.keySet());
        Collections.sort(list, (o1, o2) -> Integer.compare(h.get(o1), h.get(o2)));

        for (int i = 0; i < Math.min(K, h.size()); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
