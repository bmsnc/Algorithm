package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_27964 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        HashSet<String> h = new HashSet<>();
        String name;
        for (int i = 0; i < N; i++) {
            name = st.nextToken();
            if (name.endsWith("Cheese")) h.add(name);
        }

        System.out.println(h.size() >= 4 ? "yummy" : "sad");
    }
}
