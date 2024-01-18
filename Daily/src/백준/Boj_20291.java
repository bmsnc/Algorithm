package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20291 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        String line[];
        HashMap<String, Integer> h = new HashMap<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine().split("\\.");
            h.put(line[1], h.getOrDefault(line[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(h.keySet());
        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append(" ").append(h.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
