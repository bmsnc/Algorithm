package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5555 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String start = st.nextToken();

        int N = Integer.parseInt(br.readLine());
        StringBuilder line;
        int count = 0;
        for (int i = 0; i < N; i++) {

            line = new StringBuilder(br.readLine());
            line.append(line);
            int index = line.indexOf(start);
            if (index > -1) count++;
        }
        System.out.println(count);
    }
}
