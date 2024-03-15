package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_23059 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int max = 400001;
        int[] data = new int[max];
        List<Integer>[] list = new List[max];

        HashMap<String, Integer> h = new HashMap<>();
        HashMap<Integer, String> reverseH = new HashMap<>();
        String start, end;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = st.nextToken();
            end = st.nextToken();

            if (!h.containsKey(start)){
                h.put(start, idx);
                reverseH.put(idx, start);
                list[idx] = new ArrayList();
                idx++;
            }
            if (!h.containsKey(end)){
                h.put(end, idx);
                reverseH.put(idx, end);
                list[idx] = new ArrayList();
                idx++;
            }

            data[h.get(end)]++;
            list[h.get(start)].add(h.get(end));
        }

        List<String> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<String> tmp;
        for (int i = 0; i < idx; i++) {
            if (data[i] != 0) continue;
            result.add(reverseH.get(i));
            q.add(i);
        }
        Collections.sort(result);

        int cur, size;
        while (!q.isEmpty()){
            size = q.size();
            tmp = new ArrayList<>();
            for (int t = 0; t < size; t++) {
                cur = q.poll();
                int next;
                for (int i = 0; i < list[cur].size(); i++) {
                    next = list[cur].get(i);
                    if (--data[next] == 0){
                        q.add(next);
                        tmp.add(reverseH.get(next));
                    }
                }
            }
            Collections.sort(tmp);
            result.addAll(tmp);
        }
        if (result.size() == idx){
            for (String s : result) {
                sb.append(s).append("\n");
            }
        }else sb.append(-1);

        System.out.println(sb);
    }
}
