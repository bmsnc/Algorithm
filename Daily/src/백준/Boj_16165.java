package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16165 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> h = new HashMap<>();

        String group;
        int member;
        List<String> members;
        for (int i = 0; i < N; i++) {
            group = br.readLine();
            member = Integer.parseInt(br.readLine());
            String name;
            members = new ArrayList<>();
            for (int j = 0; j < member; j++) {
                name = br.readLine();
                members.add(name);
            }
            Collections.sort(members);
            h.put(group, members);
        }
        String find;
        int type;
        for (int i = 0; i < K; i++) {
            find = br.readLine();
            type = Integer.parseInt(br.readLine());

            if (type == 1) {
                List<String> list;
                for (String s : h.keySet()) {
                    list = h.get(s);
                    if (list.contains(find)) {
                        sb.append(s).append("\n");
                        break;
                    }
                }
            } else {
                List<String> list = h.get(find);
                for (String s : list) {
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
