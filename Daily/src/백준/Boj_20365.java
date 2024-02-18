package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20365 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String color = br.readLine();

        char start = '1', cur;
        int red = 0, blue = 0;
        for (int i = 0; i < N; i++) {

            cur = color.charAt(i);
            if (cur == 'R' && start != 'R') red++;
            else if (cur == 'B' && start != 'B') blue++;

            start = cur;
        }
        System.out.println(Math.min(red, blue) + 1);
    }
}
