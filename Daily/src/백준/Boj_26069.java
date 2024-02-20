package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_26069 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashSet<String> h = new HashSet<>();

        String a, b;
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if (h.isEmpty() && !(a.equals("ChongChong") || b.equals("ChongChong"))) continue;
            if (!h.isEmpty() && !(h.contains(a) || h.contains(b))) continue;
            if (!h.contains(a)){
                count++;
                h.add(a);
            }
            if (!h.contains(b)){
                count++;
                h.add(b);
            }
        }
        System.out.println(count);
    }
}
